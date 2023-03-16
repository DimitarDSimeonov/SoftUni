function dictionary(input) {
    let obj = {};

    for (let row of input) {
        let currentObj = JSON.parse(row);
        let entries = Object.entries(currentObj);
        let key = entries[0][0];
        let value = entries[0][1];
        obj[key] = value;
    }

    Object.keys(obj).sort().forEach(e => console.log(`Term: ${e} => Definition: ${obj[e]}`));
}

dictionary ([
    '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
    '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
    '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
    '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
    '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}'
    ]
    );