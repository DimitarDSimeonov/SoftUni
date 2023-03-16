function piccolo(input) {
    let parking = new Set();

    for (let row of input) {
        let [command, number] = row.split(", ");
        switch (command) {
            case "IN":
                parking.add(number);
                break;
            case "OUT":
                parking.delete(number);
                break;
        }
    }
    if(parking.size === 0) {
        console.log(`Parking Lot is Empty`);
    }else {
        Array.from(parking).sort().forEach(n => console.log(n));
    }
}

piccolo(['IN, CA2844AA',
'IN, CA1234TA',
'OUT, CA2844AA',
'IN, CA9999TT',
'IN, CA2866HI',
'OUT, CA1234TA',
'IN, CA2844AA',
'OUT, CA2866HI',
'IN, CA9876HH',
'IN, CA2822UU']
);