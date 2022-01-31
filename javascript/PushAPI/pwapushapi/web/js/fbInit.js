//https://firebase.google.com/docs/web/alt-setup
console.log("[fbInit.js] Running...");
import { getFirebaseConfiguration } from './fbConfig.js';
import { initializeApp } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-app.js';
import { getAnalytics, initializeAnalytics, isSupported,  setAnalyticsCollectionEnabled, setCurrentScreen, setUserId } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-analytics.js'
import { getAuth, onAuthStateChanged, createUserWithEmailAndPassword  } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-auth.js'
import { getFirestore, collection, getDocs } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-firestore.js';
import { getMessaging } from "https://www.gstatic.com/firebasejs/9.6.4/firebase-messaging.js";

globalThis.fbConfig = getFirebaseConfiguration();

console.log("[fbInit.js] using fbConfig below...");
console.log(globalThis.fbConfig);
console.log(fbConfig);
globalThis.fbApp = initializeApp(fbConfig);
console.log( globalThis.fbApp );

globalThis.fbDb = getFirestore(fbApp);
console.log( globalThis.fbDb );

globalThis.fbAuth = getAuth(fbApp);
e.log( globalThis.fbAuth );

globalThis.fbMessaging = getMessaging();
console.log( globalThis.fbMessaging );
