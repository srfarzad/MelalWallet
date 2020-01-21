package com.navin.melalwallet.ui.map;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.navin.melalwallet.R;

public class GoogleMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);


        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng myPosition = new LatLng(35.7130653,51.4070569);
        MarkerOptions maker = new MarkerOptions().position(myPosition)
                .title("Vali asr sq")
                .snippet("Android class")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));



        googleMap.addMarker(maker);


        LatLng destinationPosition = new LatLng(35.8130653,51.5970569);

        MarkerOptions makerDestination = new MarkerOptions().position(destinationPosition)
                .title("Vali asr sq")
                .snippet("Android class")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.location));



        googleMap.addMarker(makerDestination);


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(myPosition).zoom(14).build();


        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.getUiSettings().isCompassEnabled();
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);

        PolylineOptions polylineOptions = new PolylineOptions().add(myPosition,destinationPosition)
                .color(Color.parseColor("#ff0000"))
                .width(5);

        googleMap.addPolyline(polylineOptions);


        CircleOptions circleOptions = new CircleOptions().center(myPosition)
                .radius(1000)
                .fillColor(Color.parseColor("#66000000"));

        googleMap.addCircle(circleOptions);






    }
}
