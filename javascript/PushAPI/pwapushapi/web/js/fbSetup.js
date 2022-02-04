//https://firebase.google.com/docs/web/alt-setup
console.log("[fbSetup.js] Running...");
import { initializeApp } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-app.js';
import { getAnalytics, initializeAnalytics, isSupported,  setAnalyticsCollectionEnabled, setCurrentScreen, setUserId } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-analytics.js'
import { getAuth, onAuthStateChanged, createUserWithEmailAndPassword  } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-auth.js'
import { getFirestore, collection, getDocs } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-firestore.js';
import { getMessaging } from "https://www.gstatic.com/firebasejs/9.6.4/firebase-messaging.js";


async function getFirebaseConfiguration(){
    let response = await fetch("fbConfig.php");
    if (response.ok) {
	let firebaseConfig = await response.json();
	return firebaseConfig;
    } else {
	console.log("HTTP-Error: form fbConfig.js..." + response.status);
    }
}

globalThis.fbConf = await getFirebaseConfiguration();

console.log("[fbInit.js] using fbConfig below...");
console.log("=globalThis.fbConfig=");
console.log(globalThis.fbConfig);
console.log("=fbConfig=");
console.log(fbConfig);

globalThis.fbApp = initializeApp(fbConf);

export {FbApp, FbConf}
