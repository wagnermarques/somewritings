// Captura dos elementos do DOM para manipulaÃ§Ã£o (Habilidade: Manipular elementos visuais [2])
const audioElement = document.getElementById('interfaceAudio');
const btnPlayPause = document.getElementById('btnPlayPause');


let daPlayNoAudio = () => {
    audioElement.play();
}

// Funcao de Reproducao
btnPlayPause.addEventListener('click', daPlayNoAudio);

