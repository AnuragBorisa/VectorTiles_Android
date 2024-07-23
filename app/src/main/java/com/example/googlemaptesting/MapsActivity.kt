package com.example.mapboxvectortiles

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.googlemaptesting.databinding.ActivityStyleVectorSourceBinding
import com.mapbox.common.MapboxOptions
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.Style
import com.mapbox.maps.extension.style.layers.generated.lineLayer
import com.mapbox.maps.extension.style.layers.properties.generated.LineCap
import com.mapbox.maps.extension.style.layers.properties.generated.LineJoin
import com.mapbox.maps.extension.style.sources.generated.vectorSource
import com.mapbox.maps.extension.style.style

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStyleVectorSourceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        MapboxOptions.accessToken = "MAPBOXTOKEN"
        super.onCreate(savedInstanceState)

        binding = ActivityStyleVectorSourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mapView.getMapboxMap().setCamera(
            CameraOptions.Builder()
                .center(Point.fromLngLat(72.6369, 23.2156))
                .zoom(12.0)
                .build()
        )

        binding.mapView.getMapboxMap().loadStyle(
            style(Style.LIGHT) {
                +vectorSource("tiles-small") {
                    tiles(listOf("https://api/{z}/{x}/{y}.pbf"))
                }
                +lineLayer("fill-small", "tiles-small") {
                    sourceLayer("layer-0")
                    lineJoin(LineJoin.ROUND)
                    lineCap(LineCap.ROUND)
                    lineColor(Color.parseColor("#0088cc")) // Blue color fill
                    lineOpacity(0.8)
                    lineWidth(1.9)
                }
            }
        )
    }
}
