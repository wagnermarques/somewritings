package com.example.andrstud35gmapsapp;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.edu.eteczl.googlemaps.GoogleApiClientUtils;

import static android.Manifest.permission.ACCESS_BACKGROUND_LOCATION;
import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.ACCESS_WIFI_STATE;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 100;
    private GoogleMap mMap;



    //pra gente guardar a localizacao corrente do dispositivo
    private Location currentDeviceLocation;

    //esse fusedLocationCliente he a classe que fornece a localizacao do dispositivo
    private FusedLocationProviderClient fusedLocationClient;


    private Button btnLastKnowLocation;
    private Button btnPermsNotGranted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PermissionsUtils.setContext(this,this);
        PermissionsUtils.askUserForAllPermissionsNeeded();



        //GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        //int googlePlayServicesAvailable = instance.isGooglePlayServicesAvailable();
        //Toast.makeText(MapsActivity.this, " googlePlayServicesAvailable="+googlePlayServicesAvailable, Toast.LENGTH_LONG).show();


        setContentView(R.layout.layout_with_map_fragment);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        PermissionsUtils.showCurrent_Not_GrantedPermissions();


//        permissions.add(ACCESS_FINE_LOCATION);
//        permissions.add(ACCESS_COARSE_LOCATION);
//        permissionsToRequest = findUnAskedPermissions(permissions);

        this.btnLastKnowLocation = (Button) findViewById(R.id.btnLastKnowLocation);
        this.btnPermsNotGranted = (Button) findViewById(R.id.btnPermsNotGranted);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        this.btnPermsNotGranted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionsUtils.setContext(MapsActivity.this,MapsActivity.this);
                PermissionsUtils.showCurrentGrantedPermissions();
            }
        });

        this.btnLastKnowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleApiClientUtils googleApiClientUtils = new GoogleApiClientUtils(MapsActivity.this);
                Task<Location> lastKnowLocationTask = googleApiClientUtils.getLastKnowLocation();
                lastKnowLocationTask.addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Toast.makeText(MapsActivity.this, " lastKnowLocationTask SuccessListener :)", Toast.LENGTH_LONG).show();
                    }
                });

//                lastKnowLocationTask.addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MapsActivity.this, e.getCause().toString(), Toast.LENGTH_LONG).show();
//                    }
//                });


                lastKnowLocationTask.addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        Toast.makeText(MapsActivity.this, " " +location, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //Now ask for runtime permission for above android 6 OS devices

        // check permission
//        if (ActivityCompat.checkSelfPermission(this,
//                ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(this,
//                        ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//                // Solicita permissao
//                //ActivityCompat.requestPermissions(this,
//                //    new String[]
//                //            {Manifest.permission.ACCESS_FINE_LOCATION,
//                //             Manifest.permission.ACCESS_COARSE_LOCATION},
//                //            locationRequestCode);
//        } else {
//            // already permission granted
//            // get location heremFusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
//
//
//            Task task = this.fusedLocationClient.getLastLocation();
//            task.addOnSuccessListener(new OnSuccessListener() {
//                @Override
//                public void onSuccess(Object o) {
//                    Location location = (Location)o;
//                    double latitude = location.getLatitude();
//                    double longitude = location.getLongitude();
//                    Toast.makeText(
//                            MapsActivity.this,
//                            "location.getLatitude() = "+ String.valueOf(latitude).toString(),
//                            Toast.LENGTH_LONG).show();
//                }
//            });





//            if (location != null) {
//                wayLatitude = location.getLatitude();
//                wayLongitude = location.getLongitude();
//                txtLocation.setText(String.format(Locale.US, "%s -- %s", wayLatitude, wayLongitude));}
       // });
  //      }

    }







//    //Indicates that Lint should treat this type as targeting a given API level, no matter what the project target is(It just suppress the Lint error)
//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // permission was granted, yay! Do the
//                    // ACCESS_COARSE_LOCATION-related task you need to do.
//                } else {
//                    // permission denied, boo! Disable the
//                    // functionality that depends on this permission.
//                }
//
////                for (String perms : permissionsToRequest) {
////                    if (!hasPermission(perms)) {
////                        permissionsRejected.add(perms);
////                    }
////                }
////                if (permissionsRejected.size() > 0) {
////                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////                        if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
////                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
////                                    new DialogInterface.OnClickListener() {
////                                        @Override
////                                        public void onClick(DialogInterface dialog, int which) {
////                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////                                                requestPermissions(permissionsRejected.toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
////                                            }
////                                        }
////                                    });
////                            return;
////                        }
////                    }
//
//            }
//            return;
//        }// switch (requestCode) {
//    }//public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {



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



//    public void obtemLocalizacao() {
//        LocationRequest req = new LocationRequest();
//
//        req.setInterval(1000);
//        req.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        req.setSmallestDisplacement(10);
//
//        //client.requestLocationUpdates(req, this, null);
//    }

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
