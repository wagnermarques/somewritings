package eteczl.edu.br.gmaps15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityPrincipal extends AppCompatActivity {

    private Button btnQueAbreTelaComLinearLayoutVertical;
    private Button btnQueAbreTelaComLinearLayoutHorizontal;;
    private Button btnQueAbreOMapa;
    private Button btnQueAbreTelaPassandoDadosPraEla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnQueAbreTelaComLinearLayoutVertical = (Button) findViewById(R.id.btnAbreLinearLayoutVertical);
        btnQueAbreTelaComLinearLayoutHorizontal  = (Button) findViewById(R.id.btnAbreLinearLayoutHorizontal);
        btnQueAbreOMapa  = (Button) findViewById(R.id.btnAbreMapa);
        btnQueAbreTelaPassandoDadosPraEla  = (Button) findViewById(R.id.btnAbreTelaPassandoDados);

        btnQueAbreTelaComLinearLayoutVertical.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //https://developer.android.com/guide/components/intents-filters?hl=pt-br
                Intent intent = new Intent(ActivityPrincipal.this, TelaLinearLayoutVertical.class);
                startActivity(intent);
            }
        });
        btnQueAbreTelaComLinearLayoutHorizontal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPrincipal.this, TelaLinearLayoutHorizontal.class);
                startActivity(intent);
            }
        });
        btnQueAbreOMapa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPrincipal.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        btnQueAbreTelaPassandoDadosPraEla.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
                Toast.makeText(ActivityPrincipal.this,"Vamos passar pra outra activity : "+editTextNome.getText(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ActivityPrincipal.this, TelaRecebeDados.class);
                intent.putExtra("nome", editTextNome.getText().toString());
                startActivity(intent);
            }
        });

    }
}
