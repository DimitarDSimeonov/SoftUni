function focused() {
    const inputArr = Array.from(document.getElementsByTagName('input'));

    for (const input of inputArr) {
        input.addEventListener('focus', focus);
        input.addEventListener('blur', blur);
    }


    function focus(event) {
        const currentInput = event.target;
        const parentDiv = currentInput.parentElement;
        parentDiv.classList.add('focused');
    }

    function blur(event) {
        const currentInput = event.target;
        const parentDiv = currentInput.parentElement;
        parentDiv.classList.remove('focused');
    }
}