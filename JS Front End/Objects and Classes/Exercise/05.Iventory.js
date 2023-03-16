function inventory (input) {
    let heroesArr = [];

    for (let row of input) {
        let [name, level, items] = row.split(' / ');
        heroesArr.push({Hero: name, level: Number(level), items});
    }

    heroesArr.sort((a,b) => a.level - b.level);

    for (let hero of heroesArr) {
        for (const key in hero) {
            if(key === 'Hero') {
                console.log(`${key}: ${hero[key]}`);
            }else {
                console.log(`${key} => ${hero[key]}`);
            }
        }
    }
}

inventory([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]
    );