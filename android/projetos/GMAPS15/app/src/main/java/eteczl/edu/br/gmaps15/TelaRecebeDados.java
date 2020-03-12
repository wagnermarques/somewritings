package eteczl.edu.br.gmaps15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class TelaRecebeDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_recebe_dados);

        EditText editTextNestaActivityQueMostraONomeRecebido = (EditText) findViewById(R.id.editTextNomeRecebido);

        Intent intentQueAbriuEstaActivity = getIntent();
        Bundle extras = intentQueAbriuEstaActivity.getExtras();

        if( extras != null){
            Toast.makeText(this,"extras NAO tava nulo",Toast.LENGTH_LONG).show();
            String nomeRecebidoDaIntent = extras.getString("nome");
            Toast.makeText(this,"string da chave nome recebida foi : "+nomeRecebidoDaIntent,Toast.LENGTH_LONG).show();
            editTextNestaActivityQueMostraONomeRecebido.setText(nomeRecebidoDaIntent);
        }else{
            Toast.makeText(this,"extras foi nulo",Toast.LENGTH_LONG).show();
            editTextNestaActivityQueMostraONomeRecebido.setText("nome nao foi informado na activity anterior");
        }
    }
}
