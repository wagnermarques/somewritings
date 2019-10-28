package br.eteczl.andrpermapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_BACKGROUND_LOCATION;
import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity {


    private final int ALL_PERMISSIONS_RESULT = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean ANTES_PermACCESS_COARSE_LOCATION = this.checkPermissionIsGranted(this, ACCESS_COARSE_LOCATION);
        Toast.makeText(this,"ANTES_PermACCESS_COARSE_LOCATION : "+ANTES_PermACCESS_COARSE_LOCATION,Toast.LENGTH_SHORT).show();

        boolean ANTES_PermACCESS_FINE_LOCATION = this.checkPermissionIsGranted(this, ACCESS_FINE_LOCATION);
        Toast.makeText(this,"ANTES_PermACCESS_FINE_LOCATION : "+ANTES_PermACCESS_FINE_LOCATION,Toast.LENGTH_SHORT).show();

        boolean ANTES_PermACCESS_BACKGROUND_LOCATION = this.checkPermissionIsGranted(this, ACCESS_BACKGROUND_LOCATION);
        Toast.makeText(this,"ANTES_PermACCESS_BACKGROUND_LOCATION : "+ANTES_PermACCESS_BACKGROUND_LOCATION,Toast.LENGTH_SHORT).show();

        askUserForPermission(ACCESS_COARSE_LOCATION);
        askUserForPermission(ACCESS_FINE_LOCATION);
        askUserForPermission(ACCESS_BACKGROUND_LOCATION);

        boolean Depois_ANTES_PermACCESS_COARSE_LOCATION = this.checkPermissionIsGranted(this, ACCESS_COARSE_LOCATION);
        Toast.makeText(this,"Depois_ANTES_PermACCESS_COARSE_LOCATION : "+Depois_ANTES_PermACCESS_COARSE_LOCATION,Toast.LENGTH_SHORT).show();

        boolean Depois_ANTES_PermACCESS_FINE_LOCATION = this.checkPermissionIsGranted(this, ACCESS_FINE_LOCATION);
        Toast.makeText(this,"Depois_ANTES_PermACCESS_FINE_LOCATION : "+Depois_ANTES_PermACCESS_FINE_LOCATION,Toast.LENGTH_SHORT).show();

        boolean Depois_ANTES_PermACCESS_BACKGROUND_LOCATION = this.checkPermissionIsGranted(this, ACCESS_BACKGROUND_LOCATION);
        Toast.makeText(this,"Depois_ANTES_PermACCESS_BACKGROUND_LOCATION : "+Depois_ANTES_PermACCESS_BACKGROUND_LOCATION,Toast.LENGTH_SHORT).show();

    }


    //antes do lollipop a administracao das permissoes era na instalacao
    //era install time e nao como hoje, no runtime time (tempo de execucao)
    //por isso a gente precisa saber em qual plataforma android nosso software
    //esta rodando
    private static boolean platformIsAboveLollipop() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }



    public boolean checkPermissionIsGranted(MainActivity mainActivity, String perm) {
        //se for lollipo so o fato do app estar instalado
        //significa que a permissao ja foi concedido caso contrario
        //a instalacao nem ocorreria
        //entao so faz sentido checar se a plat for
        //above lollipop
        if (platformIsAboveLollipop()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (
                        ContextCompat.checkSelfPermission(this,
                                perm) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }



    private void askUserForPermission(String perm){
        //Vamos perguntar pro usuario apenas permissoes que
        //ainda nao foram concedidas
        if (!this.checkPermissionIsGranted(this, perm)) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    perm)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission

                ActivityCompat.requestPermissions(this,
                        new String[]{
                                perm},
                        ALL_PERMISSIONS_RESULT);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            Toast.makeText(this, "Permission ACCESS_COARSE_LOCATION has already been granted" , Toast.LENGTH_LONG).show();
        }
    }
}
