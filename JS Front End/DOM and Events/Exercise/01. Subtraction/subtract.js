function subtract() {
    const firstNumber = document.getElementById('firstNumber');
    const secondNumber = document.getElementById('secondNumber');
    let subtract = Number(firstNumber.value) - Number(secondNumber.value);
    const result = document.getElementById('result');
    result.textContent = subtract;
}