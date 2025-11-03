// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/12.4.0/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/12.4.0/firebase-analytics.js";

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyD0TXrX4D-XCwh9LvKKXDIGIjlmksxSmAs",
    authDomain: "aulafirebase-352f8.firebaseapp.com",
    projectId: "aulafirebase-352f8",
    storageBucket: "aulafirebase-352f8.firebasestorage.app",
    messagingSenderId: "656166399367",
    appId: "1:656166399367:web:24d926e74f76453a1cb722",
    measurementId: "G-RYSLWCBEXJ"
};

// Initialize Firebase
window.fbApp = initializeApp(firebaseConfig);
window.fbAnalytics = getAnalytics(window.app);


