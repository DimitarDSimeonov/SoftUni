function colorize() {
    const evenRows = Array.from(document.querySelectorAll('tr:nth-child(even)'));
    for (const tr of evenRows) {
        tr.style.backgroundColor = 'Teal';
    }
}