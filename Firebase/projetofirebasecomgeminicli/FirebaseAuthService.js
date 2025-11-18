import {
  getAuth,
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
  signOut as firebaseSignOut,
  onAuthStateChanged,
} from "https://www.gstatic.com/firebasejs/12.5.0/firebase-auth.js";

class FirebaseAuthService {
 
  #auth;

  constructor(firebaseApp) {
    this.#auth = getAuth(firebaseApp);
  }


  createUserWithEmailAndPassword(email, password) {
    
    createUserWithEmailAndPassword(this.#auth, email, password)
      .then((userCredential) => {
        console.log("usuario criado com sucesso:", userCredential.user);
        return userCredential.user;
      })
      .catch((error) => {
        console.error("Error creating user:", error);
        throw error;
      });
    
  }


  async signIn(email, password) {
    try {
      const userCredential = await signInWithEmailAndPassword(this.#auth, email, password);
      return userCredential.user;
    } catch (error) {
      console.error("Error signing in:", error);
      throw error;
    }
  }

  async signOut() {
    try {
      await firebaseSignOut(this.#auth);
    } catch (error) {
      console.error("Error signing out:", error);
      throw error;
    }
  }
}

export default FirebaseAuthService;
