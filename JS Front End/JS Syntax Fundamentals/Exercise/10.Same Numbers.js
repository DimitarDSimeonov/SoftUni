function sameNumbers (number) {
    let arr = number.toString();
    let result = true;

    for (let i = 0; i < arr.length - 1; i++) {
        if (arr[i] !== arr[i + 1]){
            result = false;
            break;
        }
    }
    let sum = 0;
    for (const symbol of arr) {
        sum += Number(symbol);
    }

    console.log(result);
    console.log(sum);
}

sameNumbers (2222222);
sameNumbers (1234);