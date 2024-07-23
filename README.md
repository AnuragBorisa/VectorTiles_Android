
---

# Mapbox Vector Tiles Android

This project demonstrates how to integrate Mapbox vector tiles into an Android application using the Mapbox Maps SDK for Android. The application fetches vector tiles from a custom backend and displays them on a Mapbox map.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Clone the Repository](#clone-the-repository)
  - [Setup Mapbox Access Token](#setup-mapbox-access-token)
  - [Setup Backend](#setup-backend)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [License](#license)

## Prerequisites

Before you begin, ensure you have met the following requirements:
- You have installed [Android Studio](https://developer.android.com/studio).
- You have a [Mapbox account](https://account.mapbox.com/) and have obtained a Mapbox access token.

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/mapbox-vector-tiles-android.git
cd mapbox-vector-tiles-android
```

### Setup Mapbox Access Token

1. Go to your Mapbox account and obtain your public access token.
2. Open `MainActivity.kt` and replace the placeholder access token with your actual access token:

```kotlin
MapboxOptions.accessToken = "YOUR_MAPBOX_ACCESS_TOKEN"
```

### Setup Backend

Ensure your backend is running and accessible. The backend should provide vector tiles in PBF format as specified in the URL:

```plaintext
https://api.tiles.com/0/{z}/{x}/{y}.pbf
```

## Running the Application

1. Open the project in Android Studio.
2. Sync the project with Gradle files.
3. Build and run the application on an Android device or emulator.

## Project Structure

- `MainActivity.kt`: Main activity that sets up the Mapbox map and loads vector tiles from the backend.
- `res/layout/activity_style_vector_source.xml`: Layout file for the main activity.
- `com/example/mapboxvectortiles`: Package containing the main activity and related classes.

### MainActivity.kt

This file contains the main logic for initializing the Mapbox map and loading vector tiles from the specified backend URL.

```kotlin
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
        MapboxOptions.accessToken = "YOUR_MAPBOX_ACCESS_TOKEN"
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
                    tiles(listOf("https://api.mytilesserver.com/{z}/{x}/{y}.pbf"))
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
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Feel free to customize this README file further to fit your project's specific details and needs.
