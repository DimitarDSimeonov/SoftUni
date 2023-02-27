function wordsUppercase(text) {
    let arr = text.toUpperCase().replaceAll("?", "")
                                .replaceAll(",", "")
                                .replaceAll(".", "")
                                .replaceAll("!", "")
                                .split(" ");
    
    console.log(arr.join(", "));
}

wordsUppercase('Hi, how!!! are, you?')