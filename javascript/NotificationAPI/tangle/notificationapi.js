//https://www.braziljs.org/p/web-notification-api
function isNotificationAPISupported(){
    return window.Notification? true : false;
}
/*
https://developer.mozilla.org/en-US/docs/Web/API/Notifications_API/Using_the_Notifications_API    
default (a pergunta ainda nao foi feita pro seu usuario)
granted (usuario permimtiu receber notificacoes suas)
denied (usuario nao permitiu receber notificaoes suas)	
*/
function getNotificationPermissionStatus(){
    if(isNotificationAPISupported)
	return Notification.permission;
}

function askForNotificationPermission () {
    if(isNotificationAPISupported()) {
	return new Promise((resolve, reject) => {	    
            Notification.requestPermission().then(resolve).catch(reject);
        });
    }
}

function instantiateNotification(strTitle, strBody, strIconPath){
    if(isNotificationAPISupported())
	return new Notification(strTitle, {
        body: strBody,
        icon: strIconPath // optional
    });
}

function showNotificationSimples1(){
    let titulo = 'Notificacao Simples!'
    let body = 'corpo da \n notificação'
    let icone = 'jsImg.jpeg' //https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.DN7ToydkJZEdVaJVK_NhvwHaHa%26pid%3DApi&f=1
    askForNotificationPermission().then(status => {
	console.log("Notification.permission = "+status);
	instantiateNotification(titulo,body,icone);
    });    
}
