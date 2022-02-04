    package eteczl.edu.br.firebaseauth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.jetbrains.anko.toast
import java.lang.Exception

    class MainActivity : AppCompatActivity() {

        var logTAG: String = "info";
        lateinit var btnSignUp: Button
        lateinit var btnLogin: Button
        lateinit var btnLogoff: Button
        lateinit var btnVerifyEmailUser: Button
        lateinit var btnAlteraSenha: Button


        lateinit var lbEmailDoUsuarioLogado : TextView
        lateinit var lbEmailValidoSera : TextView

        lateinit var fbAuth : FirebaseAuth
        lateinit var txtEmail: EditText
        lateinit var txtPass: EditText
        lateinit var txtNewPass: EditText

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            this.lbEmailDoUsuarioLogado = findViewById<TextView>(R.id.lbEmailDoUsuarioLogado);
            this.lbEmailValidoSera = findViewById<TextView>(R.id.lbEmailValidoSera);

            this.fbAuth = FirebaseAuth.getInstance()
            this.txtEmail = findViewById<EditText>(R.id.txtEmail);
            this.txtPass = findViewById<EditText>(R.id.txtPassw);
            this.txtNewPass = findViewById<EditText>(R.id.txtNovaSenha);


            this.btnSignUp = findViewById<Button>(R.id.btnSingUp);
            this.btnLogin = findViewById<Button>(R.id.btnLogin);
            this.btnLogoff = findViewById<Button>(R.id.btnLoggof)
            this.btnVerifyEmailUser = findViewById<Button>(R.id.btnVerifyEmailUser)
            this.btnAlteraSenha = findViewById<Button>(R.id.btnAlteraSenha)

            this.btnSignUp.setOnClickListener(View.OnClickListener {
                toast("this.btnSignUp.setOnClickListener(View.OnClickListener {...")
                this.signUp()
            })

            this.btnLogoff.setOnClickListener(View.OnClickListener {
                toast("this.btnLogoff.setOnClickListener(View.OnClickListener {...")
                this.logoff()
            })

            this.btnLogin.setOnClickListener(View.OnClickListener {
                toast("this.btnLogin.setOnClickListener(View.OnClickListener {...")
                this.login();
            })

            this.btnVerifyEmailUser.setOnClickListener(View.OnClickListener {
                toast("this.btnVerifyEmailUser.setOnClickListener(View.OnClickListener {...")
                this.verifyEmailUser();
            })

            this.btnAlteraSenha.setOnClickListener(View.OnClickListener {
                toast("this.btnAlteraSenha.setOnClickListener(View.OnClickListener {...")
                this.alteraSenha();
            })

        }

        public override fun onStart() {
            super.onStart()
            this.signUp()
            updateUI(null)
        }

        public fun updateUI(user: FirebaseUser?) {
            if (user != null) {
                this.lbEmailDoUsuarioLogado.text = user.email
            } else {
                this.lbEmailDoUsuarioLogado.text = "Nenhum User Logado"
            }
        }

        private fun logoff() {
            this.fbAuth.signOut()
            updateUI(null)
        }

        private fun login() {
            if(!this.formIsValid()){
                return
            }
            this.fbAuth.signInWithEmailAndPassword(this.txtEmail.text.toString(), this.txtPass.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        updateUI(this.fbAuth.currentUser)
                    } else {
                        toast("Usuario Logado com sucesso")
                        updateUI(null)
                    }
                    if (!task.isSuccessful) {
                        toast("Falha no login")
                    }
                }
        }

        private fun signUp(){
            if(!this.formIsValid()) return

            this.fbAuth.createUserWithEmailAndPassword(this.txtEmail.text.toString(), this.txtPass.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        toast("takswassucessfull")
                        toast(this.fbAuth.currentUser.toString())
                        updateUI(this.fbAuth.currentUser)
                    } else {
                     // If sign in fails, display a message to the user.
                        Log.w(logTAG, "createUserWithEmail:failure", task.exception)
                        toast("De uma olhada no LOGCAT que deu erro....")
                        updateUI(null)
                    }
                }
        }

        private fun verifyEmailUser() {
            var usuario = this.fbAuth.currentUser
            usuario?.sendEmailVerification()
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        toast("Verificacao de email enviada COM SUCESSO para ${usuario.email} ");
                        this.lbEmailValidoSera.text = "email valido: ${usuario.email}"
                    } else {
                        toast("Falha no envio de email de verificacao")
                        this.lbEmailValidoSera.text = "email INvalido: ${usuario.email}"
                    }
                }
        }

        private fun alteraSenha(){
            var strNewPass: String = this.txtNewPass.text.toString();
            if(strNewPass.length < 6 ){
                toast("Senha tem que ter pelo menos 6 caracteres...")
                return
            }

            var usuario = this.fbAuth.currentUser
            usuario?.updatePassword(strNewPass)?.addOnCompleteListener {
                try {
                    toast("Senha alterada com sucesso")
                }catch (e: Exception){
                    toast("Erra durante o processo de alteracao de senha")
                }
            }
        }


        private fun formIsValid() : Boolean {
            toast("private fun formIsValid() : Boolean {...")
            var ret = true
            val email: String = this.txtEmail.text.toString()
            val pass: String = this.txtPass.text.toString()

            if (email.equals("") || pass.equals("")) {
                toast("ou email ou senha estao em branco e nao pode...")
                ret = false
            } else if (pass.length < 6) {
                toast("A senha precisa ter pelo menos 6 caracteres...")
                ret = false
            }

            return ret
        }
}
