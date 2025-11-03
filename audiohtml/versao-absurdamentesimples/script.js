// Captura dos elementos do DOM para manipulaÃ§Ã£o (Habilidade: Manipular elementos visuais [2])
const audioElement = document.getElementById('interfaceAudio');
const btnPlayPause = document.getElementById('btnPlayPause');

// Funcao de Reproducao
btnPlayPause.addEventListener('click', function() {
    console.log("..btnPlayPause.addEventListener('click', function() { TOCANDO AUDIO");
    audioElement.play();
});

