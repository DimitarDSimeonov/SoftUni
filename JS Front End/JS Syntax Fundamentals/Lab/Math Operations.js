function solve(numOne, numtwo, operator) {
    switch (operator) {
        case "+":
            console.log(numOne + numtwo);
            break;
        case "-":
            console.log(numOne - numtwo);
            break;
        case "*":
            console.log(numOne * numtwo);
            break;
        case "/":
            console.log(numOne / numtwo);
            break;
        case "%":
            console.log(numOne % numtwo);
            break;
        case "**":
            console.log(numOne ** numtwo);
            break;
    }
}