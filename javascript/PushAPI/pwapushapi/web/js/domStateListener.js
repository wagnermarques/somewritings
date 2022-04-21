//https://www.designcise.com/web/tutorial/whats-the-javascript-only-substitute-for-jquerys-ready-method
document.addEventListener('readystatechange', function(event) {
    switch(event.target.readyState) {
    case 'loading':
        console.log("document is loadin");// do something
        break;
        

    case 'interactive':
	console.log("document finished loading, DOM elements are accessible");
        break;
        
        
    case 'complete':
        console.log("page is fully loaded?");
        break;
    }
});
