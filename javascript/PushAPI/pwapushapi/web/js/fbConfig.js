export default async function(){
    let response = await fetch("fbConfig.php");
    if (response.ok) {
	     return firebaseConfig = await response.json();
    } else {
	     console.log("HTTP-Error: form fbConfig.js" + response.status);
    }
}
