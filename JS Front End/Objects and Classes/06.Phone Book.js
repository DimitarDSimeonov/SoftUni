function phoneBook (input) {
    let phoneBook = {};

    for (let row of input) {
        let [ name, number ] = row.split(" ");
        phoneBook[name] = number;
    }

    let keys = Object.keys(phoneBook);
    for (let key of keys) {
        console.log (`${key} -> ${phoneBook[key]}`)
    }
}

phoneBook(
    ['George 0552554',
 'Peter 087587',
 'George 0453112',
 'Bill 0845344']
);