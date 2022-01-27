let cacheSupported = "caches" in window;

if (cacheSupported) {
    console.log("browser suporta api de cache");
    caches.open("nomeDoCache").then((cache) => {});
}else{
    console.log("browser nao suporta api de cache");
}


function criaCache(nomeDoCache){
    caches.open(nomeDoCache)
        .then((cache) => {});
}

function adicionaAoCache(url, nomeDoCache){
    caches.open(nomeDoCache).then((cache) => {
        cache.add(url).then(() => {
            console.log("Adicionei ao cache "+nomeDoCache+" a url="+url);
        });
    });
}

function btnAddToCacheListener(){
    let url = document.getElementById("urlInput").value;    
    adicionaAoCache(url,"cache1");
}


function getFromCache(cacheName, url){
    caches.open(cacheName).then(cache => {
        cache.match(url).then(posts => {
            console.log(posts);
        });
    });                
}

function btnObtemDoCacheListener(){
    let url = document.getElementById("urlInput").value;    
    getFromCache("cache1");
}

criaCache("cache1");
