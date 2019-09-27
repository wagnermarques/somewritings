package com.example.andrstud35gmapsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import br.edu.eteczl.googlemaps.MyGoogleMapsUtils;

public class UmaEmptyActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap gmap;
    private MapView nossaMapView;
    private LatLng latLngEteczl =  new LatLng(-23.523234, -46.475221);

    //private OnMapReadyCallback myMapReadyCallback = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uma_empty);

        Toast.makeText(this, "googleMap = googleMap.toString()", Toast.LENGTH_LONG).show();

        nossaMapView = (MapView) findViewById(R.id.mapView2);
        //myMapReadyCallback = new MyGoogleMapsUtils(nossaMapView);
        //nossaMapView.getMapAsync(this.myMapReadyCallback);

        nossaMapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "googleMap = "+googleMap.toString(), Toast.LENGTH_LONG).show();

        this.gmap = googleMap;
        this.gmap.setMinZoomPreference(12);
        this.gmap.moveCamera(CameraUpdateFactory.newLatLng(this.latLngEteczl));
    }
}
