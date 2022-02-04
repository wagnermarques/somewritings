export async function getFirebaseConfiguration(){
    let response = await fetch("fbConfig.php");
    if (response.ok) {
	     let firebaseConfig = await response.json();
	     return firebaseConfig;
    } else {
	     console.log("HTTP-Error: form fbConfig.js" + response.status);
    }
}
