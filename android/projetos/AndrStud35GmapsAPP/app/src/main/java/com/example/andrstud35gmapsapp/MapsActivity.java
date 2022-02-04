package com.example.andrstud35gmapsapp;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //implementation 'com.google.android.gms:play-services-location:17.0.0'
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        //Now ask for runtime permission for above android 6 OS devices

        // check permission
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                // Solicita permissao
                //ActivityCompat.requestPermissions(this,
                //    new String[]
                //            {Manifest.permission.ACCESS_FINE_LOCATION,
                //             Manifest.permission.ACCESS_COARSE_LOCATION},
                //            locationRequestCode);
        } else {
            // already permission granted
            // get location heremFusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {


            Task task = this.fusedLocationClient.getLastLocation();
            task.addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {
                    Location location = (Location)o;
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    Toast.makeText(
                            MapsActivity.this,
                            "location.getLatitude() = "+ String.valueOf(latitude).toString(),
                            Toast.LENGTH_LONG).show();
                }
            });

//            if (location != null) {
//                wayLatitude = location.getLatitude();
//                wayLongitude = location.getLongitude();
//                txtLocation.setText(String.format(Locale.US, "%s -- %s", wayLatitude, wayLongitude));}
       // });
        }

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this,"public void onMapReady(GoogleMap googleMap) {...",Toast.LENGTH_LONG).show();
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }



    public void obtemLocalizacao() {
        LocationRequest req = new LocationRequest();

        req.setInterval(1000);
        req.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        req.setSmallestDisplacement(10);

        //client.requestLocationUpdates(req, this, null);
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 1000: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    this.fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
//                        if (location != null) {
//                            wayLatitude = location.getLatitude();
//                            wayLongitude = location.getLongitude();
//                            txtLocation.setText(String.format(Locale.getDefault(), "%s -- %s", wayLatitude, wayLongitude));                    }
//                    });
//                } else {
//                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            }
//        }
//    }
}
