function oddOccurrences(input) {
    let words = input.toLowerCase().split(" ");

    let counter = {};

    for (let word of words) {
        if (!counter.hasOwnProperty(word)) {
            counter[word] = 1;
        }else {
            counter[word]++;
        }
    }
    let result = [];
    let filtered = Array.from(Object.entries(counter)).filter(a => a[1] % 2 !== 0).forEach(a => result.push(a[0]));

    console.log(result.join(" "));
}

oddOccurrences('Cake IS SWEET is Soft CAKE sweet Food');