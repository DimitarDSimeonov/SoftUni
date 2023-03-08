function oddAndEvenSum(input) {
    let oddSum = 0;
    let evenSum = 0;

    let numbers = input.toString().split("");

    for (const symbol of numbers) {
        let num = Number(symbol)
        if (num % 2 === 0) {
            evenSum += num;
        }else {
            oddSum += num;
        }
    }

    console.log (`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}