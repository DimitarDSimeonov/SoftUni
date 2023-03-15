function employees(input) {
    let employee = {}

    for(let name of input) {
        employee[name] = name.length;
    }

    for (const key in employee) {
        console.log (`Name: ${key} -- Personal Number: ${employee[key]}`);
    }
}

employees([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal']);