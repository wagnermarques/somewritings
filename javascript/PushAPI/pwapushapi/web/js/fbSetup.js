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

let fbConf = await getFirebaseConfiguration();
console.log("[fbSetup.js] using fbConf below...");
console.log("=fbConf=");
console.log(fbConf);

let fbApp = initializeApp(fbConf);
console.log("[fbApp.js] using fbAuth below...");
console.log("=fbApp=");
console.log(fbApp);

const fbAuth = getAuth();
console.log("[fbSetup.js] using fbAuth below...");
console.log("=fbAuth=");
console.log(fbAuth);

const fbFirestoreDb = getFirestore();
console.log("[fbSetup.js] using fbFirestoreDb below...");
console.log("=fbFirestoreDb=");
console.log(fbFirestoreDb);

export { fbConf, fbApp, fbAuth, fbFirestoreDb }
