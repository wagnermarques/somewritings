import { getAuth, createUserWithEmailAndPassword } from "https://www.gstatic.com/firebasejs/12.4.0/firebase-auth.js";

class FirebaseAuthService {
    #fbApp = null;
    #fbAuth = null;
    constructor(fbApp) {
        //precisamos de uma conexÃ£o com o app firebase
        //guardamos essa conexÃ£o na propriedade privada #fbApp
        //para que possamos usar essa conexÃ£o nos mÃ©todos da classe
        this.#fbApp = fbApp;
        this.#fbAuth = getAuth(this.#fbApp);        
    }

    criarContaComEmailESenha(email, password) {
        createUserWithEmailAndPassword(this.#fbAuth, email, password)
            .then((userCredential) => {
                // Signed in 
                const user = userCredential.user;
                console.log('UsuÃ¡rio criado com sucesso:', user);
            })
            .catch((error) => {
                const errorCode = error.code;
                const errorMessage = error.message;
                console.error('Erro ao criar usuÃ¡rio:', errorCode, errorMessage);
            });
    }

    logarComEmailESenha(email, password) {
        this.#fbAuth.signInWithEmailAndPassword(this.#fbAuth, email, password)
            .then((userCredential) => {
                // Signed in
                const user = userCredential.user;
                console.log('UsuÃ¡rio logado com sucesso:', user);
            })
            .catch((error) => {
                const errorCode = error.code;
                const errorMessage = error.message;
                console.error('Erro ao logar usuÃ¡rio:', errorCode, errorMessage);
                console.dir(error);
            });
    }            
    
}

export default FirebaseAuthService;
