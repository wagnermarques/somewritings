package eteczl.edu.br.exampleloginapp2

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
//import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.*


class ManterUsuarioActivity : AppCompatActivity() {

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
                    var u: Usuario = Usuario(
                        edNome.text.toString(),
                        edEmail.text.toString(),
                        edPass.text.toString()
                    )
                    UsuarioRepository(getApplicationContext()).create(u)

                    alert(
                        "Usuario Cadastrado com Sucesso",
                        "Vc ja conhecia o toast com maior duracao?") {
                            yesButton { longToast("Esse toast dura mais tempo…") }
                            noButton {}
                    }.show()

                    toast("toast normal: Usuario Incluido com sucesso")
                })
            }
            var btnList: Button = button("Listar") {

                toast("Listar Usuarios...")
                   var listU: List<Usuario> = UsuarioRepository(getApplicationContext()).findAll()
                    for (u:Usuario in listU){
                        toast(u.nome)
                    }
            }
        }
    }
}
