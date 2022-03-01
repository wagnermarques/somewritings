class FbFirestoreFeatures {

	
    static insertUser = function(user) {
	    console.log("[fbFirestoreFeatures.js] static insertUser = function(user) {...");
    }
    
    static getUsers = async function(){
	    const usersCol = collection(globalThis.fbDb, 'users');
	    const userSnapshot = await getDocs(usersCol);
	    const cityList = userSnapshot.docs.map(doc => doc.data());
	    return userList;
    }
}

export { FbFirestoreFeatures };
