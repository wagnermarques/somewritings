package br.eteczl.androidpermissions;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static android.Manifest.permission.ACCESS_BACKGROUND_LOCATION;
import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;



public class PermissionsUtils {

    //os metodos dessa classe precisam ou do ctx ou do activityContext
    //por isso tem que fornecer esses campos pra poder usar a classe
    //utilizando o metodo
    //public static void setContext(Context ctx, Activity activityContext){
    private static Context ctx;
    private static Activity activityCtx;


    //Pra gente controlar as permissoes
    private static final int ALL_PERMISSIONS_RESULT = 101;
    private static Set<String> permissionsCurrent_Granted = new HashSet<>();
    private static Set<String> permissionsCurrent_NOT_Granted = new HashSet<>();

    private static final Set<String> permissionsNeeded = new HashSet<>();
    private static Set<String> permissionsRejected = new HashSet<>();



    //preenchemos no contexto estatico pra melhorar a seguranca
    //o ideal seria unmutable collecion
    static {
        https://developer.android.com/training/location/retrieve-current
        PermissionsUtils.permissionsNeeded.add(ACCESS_COARSE_LOCATION);
        PermissionsUtils.permissionsNeeded.add(ACCESS_FINE_LOCATION);
        PermissionsUtils.permissionsNeeded.add(ACCESS_BACKGROUND_LOCATION);
    }



    //public methods
    public static void setContext(Context ctx, Activity activityContext){
        PermissionsUtils.ctx = ctx;
        PermissionsUtils.activityCtx = activityContext;
    }

    public static void askUserForAllPermissionsNeeded(){
        PermissionsUtils.askUserForASetOfPermissions(ctx,activityCtx,permissionsNeeded);
    }
    public static void showCurrentGrantedPermissions(){
        Set<String> permissionsCurrent_not_granted = PermissionsUtils.getPermissionsCurrent_NOT_Granted();
        Iterator<String> iterator = permissionsCurrent_not_granted.iterator();
        String msg = "Permissoes negadas: \n";
        while (iterator.hasNext()){
            String permNotGranted = iterator.next();
            msg += permNotGranted + "\n";
        }

        PermissionsUtils.showCancelableMessageOKCancel(msg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ctx,"asdfasdf",Toast.LENGTH_LONG);
            }
        });
    }
    public static void showCurrent_Not_GrantedPermissions(){

    }



    //private methods
    private static Set getPermissionsCurrent_NOT_Granted() {
        PermissionsUtils.permissionsCurrent_NOT_Granted  =  new HashSet<>();
        Iterator<String> permsNeededIterator = PermissionsUtils.permissionsNeeded.iterator();
        while (permsNeededIterator.hasNext()) {
            String perm = permsNeededIterator.next();
            if (!checkPermissionIsGranted(ctx, perm)) {
                PermissionsUtils.permissionsCurrent_NOT_Granted.add(perm);
            }
        }
        return PermissionsUtils.permissionsCurrent_NOT_Granted;
    }

    //antes do lollipop a administracao das permissoes era na instalacao
    //era install time e nao como hoje, no runtime time (tempo de execucao)
    //por isso a gente precisa saber em qual plataforma android nosso software
    //esta rodando
    private static boolean platformIsAboveLollipop() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    public static boolean checkPermissionIsGranted(Context ctx, String perm) {
        //se for lollipo so o fato do app estar instalado
        //significa que a permissao ja foi concedido caso contrario
        //a instalacao nem ocorreria
        //entao so faz sentido checar se a plat for
        //above lollipop
        if (platformIsAboveLollipop()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (
                        ContextCompat.checkSelfPermission(ctx,
                                perm) == PackageManager.PERMISSION_GRANTED);
            }
        }

        return true;
    }


    //trata e atualiza as permissoes do nosso app
    //perguntando pro usuarios se ele fornece as permissoes
    //que o app precisa
    //veja que pergunta TODAS que o app precisa
    //obviamente pode nao ser a melhor abordagem pro seu app profissional
    //porque pode ser melhor ir perguntando conforme precisa e nao tudo de uma vez
    //Indicates that Lint should treat this type as targeting a given API level, no matter what the project target is(It just suppress the Lint error)
    @TargetApi(Build.VERSION_CODES.M)
    private static void askUserForASetOfPermissions(Context ctx, Activity activityCtx, Set<String> setOfPerms) {

        //Pra cada permissao que a gente quer perguntar, a gente faz a pergunta
        //as permissoes que desejamos em nosso sao...
        Iterator<String> iterator = setOfPerms.iterator();
        while(iterator.hasNext()){
            String perm = iterator.next();
            askUserForPermission(ctx, activityCtx, perm);
        }

    }//private void askUserForASetOfPermissions(Context ctx, Set<String> setOfPerms) {



    private static void askUserForPermission(Context ctx, Activity activityCtx, String perm){

        //Vamos perguntar pro usuario apenas permissoes que
        //ainda nao foram concedidas
        if (!PermissionsUtils.checkPermissionIsGranted(ctx,perm)) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activityCtx,
                    perm)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission

                ActivityCompat.requestPermissions(activityCtx,
                        new String[]{
                                perm},
                        ALL_PERMISSIONS_RESULT);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            Toast.makeText(ctx, "Permission ACCESS_COARSE_LOCATION has already been granted" , Toast.LENGTH_LONG).show();
        }
    }

    private static void showCancelableMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(activityCtx)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancelar", null)
                .create()
                .show();
    }

}
