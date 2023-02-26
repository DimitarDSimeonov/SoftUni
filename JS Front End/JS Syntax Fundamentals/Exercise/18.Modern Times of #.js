function modernTimes(input) {
    let text = input.split(" ");

    for (const word of text) {
        if (word.startsWith("#") && word.length > 1) {

            let currentWord = word.toUpperCase().split("");
            let isCorrect = Boolean(true);

            for (let i = 1; i < currentWord.length; i++){
                if (currentWord[i] < 'A' || currentWord[i] > 'Z'){
                    isCorrect = Boolean (false);
                    break;
                }
            }
            if (isCorrect){
                console.log (word.substring(1));
            }
           
        }
    }
}

modernTimes('The symbol # is known #variously in English-speaking #region5s as the #number sign');