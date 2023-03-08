function loadingBar(num) {
    if (num < 100) {
        console.log (`${num}% [${"%".repeat(num / 10)}${".".repeat(10 - (num / 10))}]`);
        console.log (`Still loading...`)
    } else {
        console.log (`100% Complete!`);
        console.log (`[%%%%%%%%%%]`)
    }
}

loadingBar(50);