const sideNav = document.getElementById('side-nav');
const navOverlay = document.getElementById('nav-overlay');
const router = new Router();

// Material Design Concept: Motion Provides Meaning (Navigation)
function toggleNav() {
    const isOpen = sideNav.classList.contains('open');

    if (!isOpen) {
        // Show the sidebar (Mobile)
        sideNav.classList.add('open');
        navOverlay.classList.add('visible');
    } else {
        // Hide the sidebar (Mobile)
        sideNav.classList.remove('open');
        navOverlay.classList.remove('visible');
    }
}

// Material Design Concept: Motion Provides Meaning (Ripple Effect)
function addRipple(event) {
    const target = event.currentTarget;
    const ripple = document.createElement('span');
    ripple.classList.add('ripple-effect');

    // Set ripple color based on context (white for dark backgrounds)
    const bgColor = window.getComputedStyle(target).backgroundColor;
    if (bgColor.includes('51, 81, 181') || bgColor.includes('255, 64, 129') || bgColor.includes('48, 63, 159')) {
         ripple.style.backgroundColor = 'rgba(255, 255, 255, 0.3)';
    } else {
         ripple.style.backgroundColor = 'rgba(0, 0, 0, 0.1)';
    }

    const rect = target.getBoundingClientRect();
    const size = Math.max(rect.width, rect.height) * 2; 
    
    const x = event.clientX - rect.left - size / 2;
    const y = event.clientY - rect.top - size / 2;

    ripple.style.width = ripple.style.height = `${size}px`;
    ripple.style.left = `${x}px`;
    ripple.style.top = `${y}px`;

    target.appendChild(ripple);
    ripple.addEventListener('animationend', () => {
        ripple.remove();
    });
}

// Initial setup and resize handling for desktop/mobile differentiation
function handleResize() {
    if (window.innerWidth >= 768) { 
        sideNav.classList.add('open'); // Always open on desktop
        navOverlay.classList.remove('visible'); // No overlay needed
    } else {
         // On mobile, start hidden unless opened
        if (!sideNav.dataset.active) {
            sideNav.classList.remove('open');
        }
    }
}

// Attach the ripple effect to all interactive elements
document.addEventListener('DOMContentLoaded', () => {
    const rippleTargets = document.querySelectorAll('.menu-button, .nav-link, .fab, button[onclick="void(0)"]');
    rippleTargets.forEach(target => {
        target.style.position = 'relative';
        target.style.overflow = 'hidden';
        target.addEventListener('click', addRipple);
    });
    handleResize();
    window.addEventListener('resize', handleResize);
    
    // Initial view setup
    router.changeView('dashboard');
});