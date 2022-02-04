package loginapp.example.fzlbpms.com.br.exampleloginapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
//import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.*

import kotlinx.android.synthetic.main.activity_manter_usuario.*
import kotlinx.android.synthetic.main.activity_manter_usuario.view.*
import org.jetbrains.anko.db.insert
import java.lang.Exception

class ManterUsuarioActivity : AppCompatActivity() {

    private val INTENT_LISTAR_USUARIOS = "intentListarUsuarios"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_manter_usuario)
        //setSupportActionBar(toolbar)

        //fab.setOnClickListener { view ->
        //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //        .setAction("Action", null).show()
        //}

        lateinit var edId: TextView
        lateinit var edNome: TextView
        lateinit var edEmail: TextView
        lateinit var edPass: TextView
        var bntListar: TextView

        var edCreated: TextView

        verticalLayout {

            padding = dip(100)
            background = ColorDrawable(Color.parseColor("#F8F2F2"))

            edId = editText {
                hint = "Id Hint"
                textSize = 24f
                textColor = Color.GREEN
                //CENTER can be INHERIT GRAVITY TEXT_START TEXT_END VIEW_START VIEW_END
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
            edNome = editText {
                hint = "Nome Hint"
                textSize = 24f
                textAlignment = View.TEXT_ALIGNMENT_GRAVITY
            }
            edEmail = editText {
                hint = "email"
                textSize = 24f
            }
            edPass = editText {
                hint = "Pass"
                textSize = 24f
            }
            edCreated = editText {
                hint = "Email Hint"
                textSize = 24f
            }
            var button: Button = button("Incluir") {
                setOnClickListener(View.OnClickListener {
                    toast("Botao Incluir foi Clicado")

                    var uId = edId.text.toString()
                    var uNome = edNome.text.toString()
                    var uEmail = edEmail.text.toString()
                    var uPass = edPass.text.toString()

                    var u:Usuario = Usuario(uNome,uEmail,uPass)
                    toast("XXXXNome do Usuario para Insercao = "+u.nome)

                    try {
                        context.database.writableDatabase.insert(
                            "Usuarios",
                            "id" to u.id,
                            "nome" to u.nome,
                            "email" to u.email,
                            "senha" to u.pass
                        )
                        toast("Usuario Inserido com Sucesso")
                    }catch (e: Exception){
                        toast(e.message.toString())
                    }
                })
            }
            var buttonListView: Button = button("Abre ListView") {
                setOnClickListener {
                    toast("botao listar clicado")
                    startActivity<ListViewActivity>()
                    //val arrayList = UsuarioRepository(getApplicationContext()).findAll();
                    //arrayList.forEach(action = )
                }
            }
            var buttonListViewFromDb: Button = button("ListVewFromDb") {
                setOnClickListener {
                    startActivity<ListViewFromDBActivity>()
                    //val arrayList = UsuarioRepository(getApplicationContext()).findAll();
                    //arrayList.forEach(action = )
                }
            }


        }
    }
}
