import { app } from './firebase-config.js';
import FirebaseAuthService from './FirebaseAuthService.js';

const authService = new FirebaseAuthService(app);

const registroForm = document.getElementById('registro-form');

registroForm.addEventListener('submit', async (e) => {
  e.preventDefault();

  const email = document.getElementById('registro-email').value;
  const password = document.getElementById('registro-senha').value;

  try {
    const user = await authService.createUser(email, password);
    console.log('User created:', user);
    alert('Usuário criado com sucesso!');
  } catch (error) {
    console.error('Error creating user:', error);
    alert('Erro ao criar usuário: ' + error.message);
  }
});
