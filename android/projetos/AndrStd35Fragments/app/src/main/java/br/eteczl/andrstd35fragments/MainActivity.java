package br.eteczl.andrstd35fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
//import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnOpenFragmentBlank,btnOpenFrament_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void abreFragmentBlank(View v){
        Toast.makeText(this,"public void abreFragmentBlank(View v){...", Toast.LENGTH_LONG).show();

        //https://developer.android.com/guide/components/fragments
        //https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentManager
        //FragmentManager supportFragmentManager = getSupportFragmentManager();//getActivity().getFragmentManager();//getSupportFragmentManager();
        BlankFragment blankFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, blankFragment).commit();

        //Fragment fragmentById = fragmentManager.findFragmentById(R.id.blankFragment);
        //Toast.makeText(this,fragmentById.toString(), Toast.LENGTH_LONG).show();

        //btn_frg_one=(Button)findViewById(R.id.btn_frg_one);
    }

    public void abreFragment2(View v){
        Toast.makeText(this,"public void abreFragment2(View v){...", Toast.LENGTH_LONG).show();

        //https://developer.android.com/guide/components/fragmentsFragmentManager fragmentManager = getSupportFragmentManager();
        Fragment2 fragment2 = new Fragment2();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment2).commit();
//        Fragment fragmentById = fragmentManager.findFragmentById(R.id.blankFragment);
//        Toast.makeText(this,fragmentById.toString(), Toast.LENGTH_LONG).show();

    }

}
