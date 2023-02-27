function spiceMoreFlow (field) {
    let days = 0;
    let total = 0;

    while (field >= 100) {
        days++;
        total += field - 26;
        field -= 10;
    }

    if (total > 26) {
        total -= 26;
    }else {
        total = 0;
    }

    console.log (days);
    console.log (total);
}

spiceMoreFlow(450);