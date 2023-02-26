function stringSubstring (word, text) {
    let textArr = text.toLowerCase().split(" ");
    for (let i = 0; i < textArr.length; i++) {
        if (textArr[i] === word.toLowerCase()){
            return console.log (word);
        }
    }
    console.log (`${word} not found!`);
}

stringSubstring('javascript',
'JavaScript is the best programming language'

);