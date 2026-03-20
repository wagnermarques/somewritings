class Router {
    constructor() {
        this.navLinks = document.querySelectorAll('.nav-link');
    }

    changeView(viewId) {
        let path = '';
        if (viewId === 'dashboard') {
            path = `${viewId}.html`;
        } else {
            path = `views/${viewId}.html`;
        }

        fetch(path)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.text();
            })
            .then(html => {
                document.getElementById('content-area').innerHTML = html;
            })
            .catch(error => {
                console.error('Error fetching view:', error);
                document.getElementById('content-area').innerHTML = 
                    `<div class="card"><div class="card-title">Error</div><p>Could not load view: ${viewId}</p></div>`;
            });

        // Update active link styling
        this.navLinks.forEach(link => {
            link.classList.remove('active');
            if (link.dataset.view === viewId) {
                link.classList.add('active');
            }
        });
    }
}
