function palindromeInteger(numbers) {
    for (const num of numbers) {
        let mirrorNum = Number(num.toString().split("").reverse().join(""));

        if (num === mirrorNum) {
            console.log (true);
        }else {
            console.log (false)
        }
    }
}
