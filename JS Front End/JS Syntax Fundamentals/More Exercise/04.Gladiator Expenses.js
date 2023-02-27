function gladiatorExpenses(gameCounts, helmetPrice, swordPrice, shieldPrice, armorPrice) {
    let brokenHelm = 0;
    let brokenSword = 0;
    let brokenShield = 0;
    let brokenArmor = 0;

    for (let game = 1; game <= gameCounts; game++) {
        if (game % 2 === 0) {
            brokenHelm++
        }

        if ( game % 3 === 0) {
            brokenSword++;
        }

        if (game % 6 === 0) {
            brokenShield++;
        }

        if (game % 12 === 0) {
            brokenArmor++;
        }
    }

    let total = (brokenHelm * helmetPrice) + (brokenSword * swordPrice) + (brokenShield * shieldPrice) + (brokenArmor * armorPrice);
    console.log (`Gladiator expenses: ${total.toFixed(2)} aureus`);
}

gladiatorExpenses(23,
    12.50,
    21.50,
    40,
    200
    );