import {
    createUserWithEmailAndPassword,
    signInWithEmailAndPassword,
    updateCurrentUser,
    sendEmailVerification,
    sendPasswordResetEmail,
    verifyBeforeUpdateEmail,
    verifyPasswordResetCode} from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-auth.js'

class FbAuthFeatures {
    
    constructor(fbAuthInstance){
	this.fbAuthInstance = fbAuthInstance;
    }

    //faz login com email e senha
    signInWithEmailAndPassword (email,pass){
	console.log("[fbAuthFeatures.js] signInWithEmailAndPassword (email,pass){...");		
	
	signInWithEmailAndPassword(this.fbAuthInstance, email, pass)
	    .then(function(result){		
		console.log("[fbAuthFeatures.js] this.fbAuthInstance().signInWithEmailAndPassword(email, senha).then(function(user){..");
		console.log(".then(function(user){...");
		console.log("[fbAuthFeatures.js] .then(function(user){... =this.fbAuthInstance.currentUser=");
		document.getElementById("usuarioLogado").innerHTML = result.user.email;
	    })
	    .catch(function(error) {
		console.log("[fbAuthFeatures.js] fbAth().signInWithEmailAndPassword(email, senha).catch(function(error) {...");
		var errorCode = error.code;
		var errorMessage = error.message;
		
		if (errorCode === 'auth/wrong-password') {
		    alert('Senha errada!');
		} else {
		    alert(errorMessage);
		}           
	    });
    }//signInWithEmailAndPassword (email,pass){
    
    createUserWithEmailAndPassword(email, password){
	console.log("[fbAuthFeatures.js]   createUserWithEmailAndPassword()(email, password){...")	
	createUserWithEmailAndPassword (this.fbAuthInstance, email, password)
	    .catch(function(error) {
		var errorCode = error.code;
		var errorMessage = error.message;
		if(errorCode) alert(errorCode);
		if(errorMessage) alert(errorMessage)
	    });
    }//createUserWithEmailAndPassword(email, password){
    
    logout = function(){
	try{
	    globalThis.fbAuth().signOut();
	}catch(e){
	    alert(e);
	}
    }
}
export { FbAuthFeatures };
