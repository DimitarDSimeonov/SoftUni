function addressBook(input) {
    let addressBook = {};

    for(let row of input) {
        let [name, address] = row.split(":");
        addressBook[name] = address;
    }

    let keys = Object.keys(addressBook);
    keys.sort((a,b) => a.localeCompare(b)).forEach(k => console.log(`${k} -> ${addressBook[k]}`));
}

addressBook(
    ['Tim:Doe Crossing',
 'Bill:Nelson Place',
 'Peter:Carlyle Ave',
 'Bill:Ornery Rd']
);