function revealWord (words, text) {
    let wordsToArr = words.split(", ");
    let textToArr = text.split(" ");

    for (const word of wordsToArr) {
        for (let i = 0; i < textToArr.length; i++) {
            let currentWord = textToArr[i];
            if (currentWord.includes("*") && currentWord.length === word.length) {
                textToArr[i] = word;
                break;
            }
        }
    }
    console.log (textToArr.join(" "));
}

revealWord('great',
'softuni is ***** place for learning new programming languages'
);

revealWord('great, learning',
'softuni is ***** place for ******** new programming languages'
);