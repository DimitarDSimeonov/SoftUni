function characterInRange(first, second) {
    let min = Math.min(first.charCodeAt(0), second.charCodeAt(0));
    let max = Math.max(first.charCodeAt(0), second.charCodeAt(0));

    let result = []
    for ( let i = min + 1; i < max; i++) {
        result.push(String.fromCharCode(i));
    }

    console.log (result.join(" "));
}