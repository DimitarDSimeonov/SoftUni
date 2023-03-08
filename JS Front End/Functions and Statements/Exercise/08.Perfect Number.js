function perfectNumber(num) {
    let sum = 0;

    for (let i = 1; i <= num / 2; i++) {
        if (num % i === 0) {
            sum += i;
        }
    }

    console.log (sum === num ? `We have a perfect number!` : `It's not so perfect.`);
}

perfectNumber(1236498);