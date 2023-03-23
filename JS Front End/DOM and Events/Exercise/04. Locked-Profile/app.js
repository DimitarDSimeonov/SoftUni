function lockedProfile() {
    const buttons = Array.from(document.getElementsByTagName('button'));

    buttons.forEach(b => {
        b.addEventListener('click', toggle)
    });

    function toggle(e) {
        let btn = e.target;
        let profile = btn.parentElement;
        let unlockBtn = Array.from(profile.children)[4];
        let div = Array.from(profile.children)[9];

        if (unlockBtn.checked) {
            if(btn.textContent === 'Show more') {
                div.style.display = 'block';
                btn.textContent = 'Hide it';
            }else {
                div.style.display = 'none';
                btn.textContent = 'Show more';
            }
        }
    }
}