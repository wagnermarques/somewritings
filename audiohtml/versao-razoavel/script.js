// Captura dos elementos do DOM para manipulaÃ§Ã£o (Habilidade: Manipular elementos visuais [2])
const audioElement = document.getElementById('interfaceAudio');
const btnPlayPause = document.getElementById('btnPlayPause');
const btnStop = document.getElementById('btnStop');
const volumeSlider = document.getElementById('volumeSlider');
const statusDisplay = document.getElementById('status-feedback');

let isPlaying = false;

// FunÃ§Ã£o de ReproduÃ§Ã£o/Pausa
btnPlayPause.addEventListener('click', function() {
    if (isPlaying) {
        audioElement.pause();
        btnPlayPause.textContent = 'Play';
        statusDisplay.textContent = 'Status: Pausado.';
    } else {
        audioElement.play();
        btnPlayPause.textContent = 'Pause';
        statusDisplay.textContent = 'Status: Reproduzindo som fonogrÃ¡fico.';
    }
    isPlaying = !isPlaying; 
});

// FunÃ§Ã£o de Parar
btnStop.addEventListener('click', function() {
    audioElement.pause();
    // Reinicia o tempo de reproduÃ§Ã£o para o inÃ­cio
    audioElement.currentTime = 0; 
    isPlaying = false;
    btnPlayPause.textContent = 'Play';
    statusDisplay.textContent = 'Status: Interrompido e resetado.';
});

// Controle de Volume
volumeSlider.addEventListener('input', function() {
    // Ajusta o volume do elemento de Ã¡udio
    audioElement.volume = this.value;
    const percentual = Math.round(this.value * 100);
    statusDisplay.textContent = `Status: Volume ajustado para ${percentual}%.`;
});

// Feedback ao tÃ©rmino (Elemento de Design Digital: Gerenciamento do estado da interface)
audioElement.addEventListener('ended', function() {
    isPlaying = false;
    btnPlayPause.textContent = 'Play';
    statusDisplay.textContent = 'Status: Elemento sonoro finalizado.';
});
