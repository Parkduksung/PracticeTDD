package com.example.kakaoapi

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.kakaoapi.databinding.ActivityMainBinding
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mapView: MapView

    private lateinit var gpsTracker: GpsTracker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUi()

    }

    private fun initUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        checkPermission()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            999 -> {
                loadMapView()
            }

            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }

    }

    private fun loadMapView() {
        mapView = MapView(this)


        mapView.setMapViewEventListener(object : MapView.MapViewEventListener {
            override fun onMapViewInitialized(p0: MapView?) {

            }

            override fun onMapViewCenterPointMoved(p0: MapView?, p1: MapPoint?) {
            }

            override fun onMapViewZoomLevelChanged(p0: MapView?, p1: Int) {
            }

            override fun onMapViewSingleTapped(p0: MapView?, p1: MapPoint?) {
            }

            override fun onMapViewDoubleTapped(p0: MapView?, p1: MapPoint?) {
            }

            override fun onMapViewLongPressed(p0: MapView?, p1: MapPoint?) {
            }

            override fun onMapViewDragStarted(p0: MapView?, p1: MapPoint?) {
            }

            override fun onMapViewDragEnded(p0: MapView?, p1: MapPoint?) {
            }

            override fun onMapViewMoveFinished(p0: MapView?, p1: MapPoint?) {
            }
        })


        gpsTracker = GpsTracker(this)

        val mapPoint = MapPoint.mapPointWithGeoCoord(
            gpsTracker.latitude,
            gpsTracker.longitude
        )

        val mapPOIItem = MapPOIItem().apply {
            itemName = "currentLocation"
            this.mapPoint = mapPoint
        }


        mapView.addPOIItem(mapPOIItem)
        mapView.setMapCenterPoint(mapPoint, true)


        binding.containerMap.addView(mapView)


    }


    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 999)
        } else {
            loadMapView()
        }

    }
}