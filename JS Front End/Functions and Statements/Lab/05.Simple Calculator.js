function simpleCalculator(numOne, numTwo, operator) {

    const multiply = (a, b) => a * b;
    const divide = (a, b) => a / b;
    const add = (a, b) => a + b;
    const subtract = (a, b) => a - b;

    switch (operator) {
        case "multiply":
            return multiply(numOne, numTwo);
        case "divide":
            return divide(numOne, numTwo);
        case "add":
            return add(numOne, numTwo);
        case "subtract":
            return subtract(numOne, numTwo);
    }
}