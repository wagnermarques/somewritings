async function insertUser(){

}

async function getUsers(){
    const usersCol = collection(db, 'users');
    const userSnapshot = await getDocs(usersCol);
    const cityList = userSnapshot.docs.map(doc => doc.data());
    return userList;
}
