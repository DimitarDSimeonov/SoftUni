function wordTracker(input) {
    let searchingWord = {};
    for(let word of input[0].split(" ")){
        searchingWord[word] = 0
    }

    for(let i = 1; i < input.length; i++) {
        let word = input[i];
        if (searchingWord.hasOwnProperty(word)) {
            searchingWord[word]++;
        }
    }
    let sorted = Object.entries(searchingWord).sort((a,b) => b[1] - a[1]).forEach(e => console.log(`${e[0]} - ${e[1]}`));
}

wordTracker([
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
    ]
    );

    wordTracker([
        'is the', 
        'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']
        );