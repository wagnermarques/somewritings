package eteczl.edu.br.firebaseauth


import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Deferred


class FirebaseAuthFeatures(auth : FirebaseAuth, activity : Activity) : IAuth<AuthResult>{

    override fun getCurrentUser(): Deferred<AuthResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registraUsuario(): Deferred<AuthResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    var logTAG: String = "info";
    var fbAuth = auth;
    var activityUsingThisClass = activity;

//    fun registrarUsuario(email: String, pass: String) : Promise<FirebaseUser>{
//        this.fbAuth.createUserWithEmailAndPassword(email, pass)
//            .addOnCompleteListener(activityUsingThisClass) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(logTAG, "this.fbAuth.createUserWithEmailAndPassword(this.txtEmail, this.txtPass):success")
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(logTAG, "createUserWithEmail:failure", task.exception)
//                }
//            }
//    }
//
//
//    fun login(): FirebaseUser {
//
//    }
//
//    fun obtemUsuarioLogado():FirebaseUser {
//
//    }


}