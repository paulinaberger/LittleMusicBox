package org.android.mdsd2016.android.soundplayerpaulina;

import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

/**
 * Created by paulinaberger on 2017-04-01.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
         SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

         LatLng markerLoc = new LatLng(getIntent().getFloatExtra("lat", 0f), getIntent().getFloatExtra("lng", 0f));
        mMap.addMarker(new MarkerOptions().position(markerLoc).title("Song's Location"));
        //Animating the camera to zoom. Try changing the second argument "12.0f" for different zoom level
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(markerLoc, 2.0f));
    }
}