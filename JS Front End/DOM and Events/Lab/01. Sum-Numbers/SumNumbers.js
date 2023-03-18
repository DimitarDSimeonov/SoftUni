function calc() {
    let a = document.getElementById("num1");
    let b = document.getElementById("num2");
    let sum = document.getElementById("sum");

    let first = Number(a.value);
    let second = Number(b.value);
    sum.value = first + second;
}
