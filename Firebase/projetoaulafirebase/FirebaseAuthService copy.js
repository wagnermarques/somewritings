import { 
    getAuth, 
    createUserWithEmailAndPassword,
    signInWithEmailAndPassword,
    signInWithPopup,
    signOut,
    sendPasswordResetEmail,
    //currentUser,
    updateProfile,
    getIdToken,
    sendEmailVerification,
    updatePassword } from "https://www.gstatic.com/firebasejs/12.4.0/firebase-auth.js";

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
    


    //Permite que o usuário faça login com um provedor de identidade federada (como Google, Facebook) por meio de uma janela pop-up.
    //signInWithPopup(auth, provider)


    //Remove o usuário atualmente autenticado e limpa o token de sessão.
    //signOut(auth)

    
    //Envia um e-mail para redefinir a senha do usuário.
    //sendPasswordResetEmail(auth, email)

    
    
    //Obtém o objeto do usuário logado no momento. 
    //Retorna um objeto User se houver um usuário logado, ou null caso contrário. 
    //É síncrono.    
    //auth.currentUser


    //
    //Atualiza as propriedades básicas do perfil do usuário, 
    //como displayName (nome de exibição) 
    //e photoURL (URL da foto).

    //updateProfile(user, profile)


    
    //Obtém o token JWT (JSON Web Token) do usuário. 
    //Crucial para autenticar requisições no seu back-end (como uma API PHP).
    
    //getIdToken(user, forceRefresh)

    //Envia um e-mail de verificação para o endereço de e-mail do usuário logado.    
    //sendEmailVerification(user)


    /*
    Permite que o usuário logado altere sua senha. 
    Requer reautenticação recente por questões de segurança.
    */
    resetarSenha(user, newPassword){        
        user = this.#fbAuth.currentUser;
        updatePassword(user, "novaSenhaSegura")
            .then(() => {
                console.log("Senha alterada com sucesso!");
            })
            .catch((error) => {
                // Se o erro for 'auth/requires-recent-login', sera necessario primeiro reautenticar o usuário.
                console.error("Erro ao alterar senha:", error);
            });
    }
    
}

export default FirebaseAuthService;
