package br.edu.eteczl.googlemaps;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;

public class GoogleApiClientUtils implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private final String logTag = "GoogleApiClientUtils";
    private Context ctx;
    private GoogleApiClient.Builder googleApiClient;
    FusedLocationProviderClient fusedLocationProviderClient;


    public GoogleApiClientUtils(Context ctx){
        this.ctx = ctx;
        this.googleApiClient = new GoogleApiClient.Builder(ctx);
        this.googleApiClient.addApi(LocationServices.API);
        this.googleApiClient.addConnectionCallbacks(this);
        this.googleApiClient.addOnConnectionFailedListener(this);
        this.googleApiClient.build().connect();
    }

    public Task<Location> getLastKnowLocation(){
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.ctx);
        return this.fusedLocationProviderClient.getLastLocation();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d(this.logTag, " >>>>>> public void onConnected(@Nullable Bundle bundle) {");
        Log.d(this.logTag, " >>>>>> google cliente conectado");
//        Log.d(this.logTag, " >>>>>> bundle.describeContents():" + bundle.describeContents());
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(this.logTag, " >>>>>> public void onConnected(@Nullable Bundle bundle) {...");
        Log.d(this.logTag, " >>>>>> google cliente conectado");
        Log.d(this.logTag, " >>>>>> bundle.describeContents():" + i);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(this.logTag, " >>>>>> public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {...");
        Log.d(this.logTag, " >>>>>> google cliente CONNECTION FALHOU");
        Log.d(this.logTag, " >>>>>> bundle.describeContents():" + connectionResult.getErrorMessage());
    }
}
