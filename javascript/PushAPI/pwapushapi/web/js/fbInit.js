//https://firebase.google.com/docs/web/alt-setup
import { initializeApp } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-app.js';
import { getAnalytics, initializeAnalytics, isSupported,  setAnalyticsCollectionEnabled, setCurrentScreen, setUserId } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-analytics.js'
import { getAuth, onAuthStateChanged, createUserWithEmailAndPassword  } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-auth.js'
import { getFirestore, collection, getDocs } from 'https://www.gstatic.com/firebasejs/9.6.4/firebase-firestore.js';
import { getMessaging, getToken } from "https://www.gstatic.com/firebasejs/9.6.4/firebase-messaging.js";

const globalThis.fbApp = initializeApp(firebaseConfig);
const globalThis.fbDb = getFirestore(fbApp);
const globalThis.fbAuth = getAuth(fbApp);

//const messaging = getMessaging();
