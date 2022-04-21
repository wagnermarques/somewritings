self.addEventListener('install', event => {
    console.log('sw ./ => installing...');
});

self.addEventListener('activate', event => {
    console.log('sw ./ => Evento activate ocorreu, agora pronto pra interceptar fetches');
});

self.addEventListener('fetch', event => {
    ///console.log("sw ./ => Detectei um evento fetch para o recurso abaixo:");
    //console.log("sw ./ => "+event.request.url);
});
