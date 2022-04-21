console.log("[main.js] Loaded Sucessfully!")
if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('/service-worker-push-notification.js')
	.then(function(registration) {
	    alert('Registration successful, scope is:', registration.scope);
	})
	.catch(function(error) {
	    console.log('Service worker registration failed, error:...', error);
	    throw(error);
	});
}
