// Captura dos elementos do DOM para manipulaÃ§Ã£o (Habilidade: Manipular elementos visuais [2])
const audioElement = document.getElementById('interfaceAudio');
const btnPlayPause = document.getElementById('btnPlayPause');
const btnStop = document.getElementById('btnStop');

let isPlaying = false;

// FunÃ§Ã£o de ReproduÃ§Ã£o/Pausa
btnPlayPause.addEventListener('click', function() {
    if (isPlaying) {
        audioElement.pause();
        btnPlayPause.textContent = 'Play';
    } else {
        audioElement.play();
        btnPlayPause.textContent = 'Pause';
    }
    isPlaying = !isPlaying; 
});

// Funcao de Parar
btnStop.addEventListener('click', function() {
    audioElement.pause();
    // Reinicia o tempo de reproduÃ§Ã£o para o inÃ­cio
    audioElement.currentTime = 0; 
    isPlaying = false;
    btnPlayPause.textContent = 'Play';
});

