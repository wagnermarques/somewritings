package br.eteczl.andrpermapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_BACKGROUND_LOCATION;
import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity {


    private final int ALL_PERMISSIONS_RESULT = 101;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View btnPedePermissao = findViewById(R.id.btnPedePermissao);
        btnPedePermissao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.solicitaPermissaoDeLocation();
            }
        });
    }




    //antes do lollipop a administracao das permissoes era na instalacao
    //era install time e nao como hoje, no runtime time (tempo de execucao)
    //por isso a gente precisa saber em qual plataforma android nosso software
    //esta rodando
    private boolean platformIsAboveLollipop() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }


    public boolean permissaoConcedida(String perm) {

        if (platformIsAboveLollipop()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //Toast.makeText(this,"PackageManager.PERMISSION_GRANTED = "+PackageManager.PERMISSION_GRANTED, Toast.LENGTH_SHORT).show();
                return (ContextCompat.checkSelfPermission(this, perm) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }


    public void solicitaPermissaoDeLocation(){
        Toast.makeText(this,"public void solicitaPermissaoDeLocation(){...", Toast.LENGTH_SHORT).show();
        askUserForPermission(ACCESS_COARSE_LOCATION);
    }

    private void askUserForPermission(String perm){
        //Vamos perguntar pro usuario apenas permissoes que
        //ainda nao foram concedidas
        if (!this.permissaoConcedida(perm)) {

            // Permission is not granted
            // Should we show an explanation?
            //Toast.makeText(this, "Permission "+perm+ "###AINDA NAO FOI concedida anteriormente" , Toast.LENGTH_LONG).show();

//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, perm)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
//            } else {
                // No explanation needed; request the permission

                ActivityCompat.requestPermissions(this, new String[]{perm}, ALL_PERMISSIONS_RESULT);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
//            }
        } else {
            // Permission has already been granted
            Toast.makeText(this, "PERMISSAO "+perm+ " ja foi concedida anteriormente" , Toast.LENGTH_LONG).show();
        }
    }
}
