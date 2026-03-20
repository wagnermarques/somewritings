import { 
    getFirestore,
    //adicionar dados
    collection, addDoc 
 } from "https://www.gstatic.com/firebasejs/12.4.0/firebase-firestore.js";

class FirebaseFirestoreService {
    
    #fbApp = null;
    #fbFirestoreDb = null;
    
    constructor(fbApp) {
        this.#fbApp = fbApp;
        this.#fbFirestoreDb = getFirestore(this.#fbApp);
    }

    //https://github.com/firebase/snippets-web/blob/95c8c159ff4d90af442352f058406f1aeb8adcbb/snippets/firestore-next/test-firestore/add_ada_lovelace.js#L8-L19
    async criaDocumentoEmUmaColecao(nomedacolecao,jsonLiteralDoc){        
        console.log("async criaDocumentoEmUmaColecao(nomedacolecao,jsonLiteralDoc){...");
        try {
            console.log("trying... const docRef = await addDoc(collection(this.#fbFirestoreDb, nomedacolecao), jsonLiteralDoc);");
            const docRef = await addDoc(collection(this.#fbFirestoreDb, nomedacolecao), jsonLiteralDoc);
            console.log("Document written with ID: ", docRef.id);
        } catch (e) {
            console.error("Error adding document: ", e);
        }
    }

//"setDoc(docRef, data, options)","Define (cria ou sobrescreve) o documento em um caminho específico (docRef). Se o documento já existir, ele será substituído. Use setDoc(docRef, data, { merge: true }) para mesclar os novos campos com os existentes.","javascript\nimport { doc, setDoc } from ""firebase/firestore"";\n\nconst userRef = doc(db, ""usuarios"", ""alicia"");\n\nawait setDoc(userRef, {\n  nome: ""Alice"",\n  cidade: ""São Paulo""\n});\n"
//"addDoc(collectionRef, data)",Adiciona um novo documento a uma coleção. O Firestore gera automaticamente um ID exclusivo para o novo documento.,"javascript\nimport { collection, addDoc } from ""firebase/firestore"";\n\nconst usersCol = collection(db, ""usuarios"");\n\nawait addDoc(usersCol, {\n  nome: ""Bruno"",\n  cidade: ""Rio de Janeiro""\n});\n"
//"updateDoc(docRef, data)","Atualiza campos específicos de um documento existente. Se o campo não existir, ele será adicionado. Não substitui o documento inteiro.","javascript\nimport { doc, updateDoc } from ""firebase/firestore"";\n\nconst userRef = doc(db, ""usuarios"", ""alicia"");\n\nawait updateDoc(userRef, {\n  cidade: ""Campinas"",\n  ultimaAtualizacao: new Date()\n});\n"
//deleteDoc(docRef),Exclui um documento específico.,"javascript\nimport { doc, deleteDoc } from ""firebase/firestore"";\n\nconst userRef = doc(db, ""usuarios"", ""alicia"");\n\nawait deleteDoc(userRef);\n"
    

}

export default FirebaseFirestoreService;
