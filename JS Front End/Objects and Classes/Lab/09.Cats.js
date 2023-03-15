function cats(input) {
    let cats = {};

    for( let row of input) {
        let [name, age] = row.split(" ");
        cats[name] = age;
    }

    let keys = Object.keys(cats);
    keys.forEach(k => console.log(`${k}, age ${cats[k]} says Meow`));
}