function solve(arr) {
    let even = 0;
    let odd = 0;

    for(let i = 0; i < arr.length; i++) {
        arr[i] = Number(arr[i]);

        if (arr[i] % 2 === 0) {
            even += arr[i];
        }else {
            odd += arr[i];
        }
    }

    console.log (even - odd);
}

