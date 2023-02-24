function sumDigits(number) {
    let numberToStr = number.toString();
    let sum = 0;

    for (const strDigit of numberToStr) {
        sum += Number(strDigit);
    }

    console.log (sum);
}

sumDigits(245678);
sumDigits(97561);
sumDigits(543);