function sortingNumbers (numbers) {

    numbers.sort((a,b) => {return a - b});

    let newArr = [];

    while (numbers.length !== 0) {
        newArr.push(numbers.shift());
        newArr.push(numbers.pop());
    }

    return newArr;
}