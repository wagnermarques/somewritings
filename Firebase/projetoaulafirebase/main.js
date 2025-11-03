import FirebaseAuthService from './FirebaseAuthService.js';
let firebaseAuthService = new FirebaseAuthService(window.fbApp);

firebaseAuthService.criarContaComEmailESenha('wagnerdocri@gmail.com','123456789');
window.app
