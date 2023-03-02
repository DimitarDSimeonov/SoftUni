function singCheck(...numbers) {
    return numbers
    .filter(n => n < 0)
    .length % 2 === 0 ? "Positive" : "Negative";
}

