function factorialDivision(firstNum, secondNum) {
    function factorial(n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    console.log((factorial(firstNum) / factorial(secondNum)).toFixed(2));
}

factorialDivision(5, 2);