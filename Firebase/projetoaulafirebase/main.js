import FirebaseFirestoreService from './FirebaseFirestoreService.js';
import FirebaseAuthService from './FirebaseFirestoreService.js';
import FirebaseFirestore from './FirebaseFirestoreService.js';

let firebaseAuthService = new FirebaseAuthService(window.fbApp);
let firebaseFirestoreService = new FirebaseFirestoreService(window.fbApp);


//firebaseAuthService.criarContaComEmailESenha('wagnerdocri@gmail.com','123456789');
firebaseFirestoreService.criaDocumentoEmUmaColecao("usuarios",{"nome":"blaze pascal"});
firebaseFirestoreService.criaDocumentoEmUmaColecao("usuarios",{"nome":"imanuel kant"});







window.app
