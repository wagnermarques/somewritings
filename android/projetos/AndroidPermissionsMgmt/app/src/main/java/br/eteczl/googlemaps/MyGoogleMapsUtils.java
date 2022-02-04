package br.edu.eteczl.googlemaps;

import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class MyGoogleMapsUtils implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap gmap;

    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";
    LatLng latLngEteczl = new LatLng(-23.523234, -46.475221);


    public MyGoogleMapsUtils(MapView mapView){
        this.mapView = mapView;
    }


    public void setGmap(GoogleMap gMap){
        this.gmap = gMap;
    }
    public void setMapView(MapView mapView){
        this.mapView = mapView;
    }

    public GoogleMap getGmap(){
        return this.gmap;
    }
    public MapView getMapView(){
            return this.mapView;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.i("###@@@","public void onMapReady(GoogleMap googleMap) {...");
        Log.i("###@@@", googleMap.toString());
        gmap = googleMap;
        gmap.setMinZoomPreference(12);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(this.latLngEteczl));
    }
}
