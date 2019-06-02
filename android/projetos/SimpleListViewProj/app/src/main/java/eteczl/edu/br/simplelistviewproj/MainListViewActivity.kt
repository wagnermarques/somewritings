package eteczl.edu.br.simplelistviewproj

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_main_list_view.*

class MainListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list_view)
        setSupportActionBar(toolbar)

        //PESSOAL OS PROJETOS DO NOSSO LAB NAO TEM SNACKBAR,
        //NAO USEM ESSE CODIGO NESTE CASO :))
        //OUTRA COISA..
        //NAO COPIEM AS SUGESTOES DE CONTEXTO DO ANDROID STUDIO
        //A PRIMEIIRA LINHA AQUI, VOCE SO ESCREVE ISSO QUE ESTA
        //ABAIXO NO MEU COMENTARIO...

     // fab.setOnClickListener { view ->
     //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)

        //isso se aplica ao restante do codigo
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        //NA PROXIMA IMAGEM TEM O CODIGO QUE VAI USAR O LISTVIEW
        //AQUI VAI SO ALGUMAS ORIENTACOES

        val arrayDeLinhasQueSeraMostradoNaListView = ArrayList<String>()
        arrayDeLinhasQueSeraMostradoNaListView.add("Linha 1")
        arrayDeLinhasQueSeraMostradoNaListView.add("Linha 2")
        arrayDeLinhasQueSeraMostradoNaListView.add("Linha 3")
        arrayDeLinhasQueSeraMostradoNaListView.add("Linha 4")

        val lv: ListView = findViewById(R.id.minhaprimeiralistview)
        lv.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrayDeLinhasQueSeraMostradoNaListView)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main_list_view, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
