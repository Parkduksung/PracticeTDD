package com.example.kakaoapi

import android.Manifest
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.IBinder
import android.util.Log
import androidx.core.content.ContextCompat

class Gps(private val context: Context) : Service(), LocationListener {

    private lateinit var location: Location

    var longitude: Double = 0.0
    var latitude: Double = 0.0

    private fun getLocation(): Location? {
        try {
            val locationManager = context.getSystemService(LOCATION_SERVICE) as LocationManager

            val isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetworkEnabled =
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if (!isGPSEnabled && !isNetworkEnabled) {
                Log.d("여기1", "!isGPSEnabled && !isNetworkEnabled")
            } else {
                val hasFineLocationPermission =
                    ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                val hasCoarseLocationPermission =
                    ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )

                if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                    hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED
                ) {
                    Log.d("여기2", "!isGPSEnabled && !isNetworkEnabled")
                } else {
                    return null
                }

                if (isNetworkEnabled) {
                    try {
                        locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES.toLong(),
                            MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(),
                            this
                        )
                        location =
                            locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)!!
                        latitude = location.latitude
                        longitude = location.longitude

                    } catch (e: Exception) {
                        Log.d("getLocationError", e.toString())
                        return null
                    }
                }


                if (isGPSEnabled) {
                    if (!::location.isInitialized) {

                        try {
                            locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES.toLong(),
                                MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(),
                                this
                            )

                            location =
                                locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)!!
                            latitude = location.latitude
                            longitude = location.longitude
                        } catch (e: Exception) {
                            Log.d("getLocationError", e.toString())
                            return null
                        }
                    }
                }
            }

        } catch (e: Exception) {
            Log.d("getLocationError", e.toString())
            return null
        }

        return location
    }

    override fun onLocationChanged(p0: Location) {
    }


    companion object {
        private const val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 10
        private const val MIN_TIME_BW_UPDATES: Long = 1000 * 60 * 1
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}