// Get registration token. Initially this makes a network call, once retrieved
// subsequent calls to getToken will return from cache.

//import { getMessaging, getToken } from "https://www.gstatic.com/firebasejs/9.6.4/firebase-messaging.js";

getToken(messaging, { vapidKey: 'YOUR_PUBLIC_VAPID_KEY_HERE' }).then((currentToken) => {
  if (currentToken) {
    // Send the token to your server and update the UI if necessary
    // ...
  } else {
    // Show permission request UI
    console.log('No registration token available. Request permission to generate one.');
    // ...
  }
}).catch((err) => {
  console.log('An error occurred while retrieving token. ', err);
  // ...
});
