// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/12.4.0/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/12.4.0/firebase-analytics.js";

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyCMlrRgJjbU34tAIJtPTnfn8I8b2rs63Bw",
  authDomain: "tasktodayapp-794ff.firebaseapp.com",
  projectId: "tasktodayapp-794ff",
  storageBucket: "tasktodayapp-794ff.firebasestorage.app",
  messagingSenderId: "319887135161",
  appId: "1:319887135161:web:594bef2546b9c4f26da668",
  measurementId: "G-ZMSZ4DDPW7"
};

// Initialize Firebase
window.fbApp = initializeApp(firebaseConfig);
window.fbAnalytics = getAnalytics(window.fbApp);


