package loginapp.example.fzlbpms.com.br.exampleloginapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_list_view_from_db.*
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.toast
import java.lang.Exception

class ListViewFromDBActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_from_db)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    try {
        var listViewFromDB = findViewById<ListView>(R.id.listviewFromDb)
        val arrayDeUsuariosFromDBA: ArrayList<Usuario> = ArrayList<Usuario>()

        applicationContext.database.use {

            select("usuarios").parseList(object : MapRowParser<List<Usuario>> {
                override fun parseRow(columns: Map<String, Any?>): List<Usuario> {
                    var uNome = columns.getValue("nome") as String
                    var u: Usuario = Usuario(uNome, "", "")
                    arrayDeUsuariosFromDBA.add(u)
                    toast(u.toString())
                    return arrayDeUsuariosFromDBA
                }
            })

            for(u:Usuario in arrayDeUsuariosFromDBA){
                toast(u.nome)
            }

        }

        var arrayListDeNomes: List<String> = obtemArrayListComNomesDosUsuarios(arrayDeUsuariosFromDBA)
        for(nome: String in arrayListDeNomes){
            toast(nome)
        }
        listViewFromDB.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListDeNomes)
        toast("select sucesso")
    }catch (e: Exception){
        toast(e.message.toString())
    }
    }

    private fun obtemArrayListComNomesDosUsuarios(arrayDeUsuariosFromDBA: ArrayList<Usuario>): List<String> {
        var arrNomes : ArrayList<String> = ArrayList<String>()
        for(u:Usuario in arrayDeUsuariosFromDBA){
            arrNomes.add(u.nome)
        }
        return arrNomes
    }

}
