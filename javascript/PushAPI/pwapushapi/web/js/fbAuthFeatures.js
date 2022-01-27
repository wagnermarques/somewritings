function login(){
    console.log("function login(){...");
    console.log(fbApp);
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
        
        fbAuth().signInWithEmailAndPassword(email, senha).then(function(user){
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


function signup(){
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
}


function logout(){
    try{
        fbAuth().signOut();
    }catch(e){
        alert(e);
    }
}
