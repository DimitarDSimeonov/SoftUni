function sumTable() {
    const pricesArr = Array.from(document.querySelectorAll('td:nth-child(even)'));
    let totalSum = 0;
    for (let i = 0; i < pricesArr.length - 1; i++) {
        totalSum += Number(pricesArr[i].textContent);
    }

    let sum = document.getElementById('sum');
    sum.textContent = totalSum;
}