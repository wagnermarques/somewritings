class FbAuth {

    static signInWithEmailAndPassword = function(email,pass){		
	       console.log("[fbAuthFeatures.js] static signInWithEmailAndPassword = function(email,pass){...");
	       console.log("=global.fbAuth=")
	       console.log(global.fbAuth)

		 try{
		    let email = document.getElementById("user_email").value;
		    let senha = document.getElementById("user_password").value;

		    if(email.length == 0) {
			alert ("digite um email");
			return false;
		    }

		    if(senha.length == 0){
			alert ("digite um uma senha");
			return false;
		    }

		    globalThis.fbAuth().signInWithEmailAndPassword(email, senha).then(function(user){
			console.log("fbAuth().signInWithEmailAndPassword(email, senha).then(function(user){...");
			console.log(user);	
		    }).catch(function(error) {
			console.log("fbAth().signInWithEmailAndPassword(email, senha).catch(function(error) {...");
			var errorCode = error.code;
			var errorMessage = error.message;

			if (errorCode === 'auth/wrong-password') {
			    alert('Senha errada!');
			} else {
			    alert(errorMessage);
			}           
		    });                
		}catch(e){
		    console.log(e);
		}
}

static signup = function(){
    console.log("[fbAuthFeatures.js]   static signup = function(){...")
    console.log("=global.fbAuth=")
    console.log(global.fbAuth)

    let email = document.getElementById("user_email").value;
    let senha = document.getElementById("user_password").value;

    if(email.length == 0) {
	alert ("digite um email");
	return false;
    }

    if(senha.length == 0){
	alert ("digite um uma senha");
	return false;
    }

    fbAuth.createUserWithEmailAndPassword(email, senha).catch(function(error) {
	var errorCode = error.code;
	var errorMessage = error.message;
	if(errorCode) alert(errorCode);
	if(errorMessage) alert(errorMessage);
    })
}//static signup = function()

static logout = function(){
    try{
	globalThis.fbAuth().signOut();
    }catch(e){
	alert(e);
    }
}
}
export { FbAuth };
