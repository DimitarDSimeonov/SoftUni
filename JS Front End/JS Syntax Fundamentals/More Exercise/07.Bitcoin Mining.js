function bitcoinMining(arr) {
    let bitcoinPrice = 11949.16;
    let goldPrice = 67.51;
    let dayOfFirstBitcoin = 0;
    let totalBitcoin = 0;
    let money = 0;

    for (let i = 0; i < arr.length; i++) {
        let moneyOfDay = arr[i] * goldPrice;

        if ((i + 1) % 3 === 0) {
            moneyOfDay *= 0.7;
        }

        money += moneyOfDay;
        while (money > bitcoinPrice) {
            money -= bitcoinPrice;
            if (totalBitcoin === 0) {
                dayOfFirstBitcoin = i + 1;
            }
            totalBitcoin++;
        }
    }

    console.log(`Bought bitcoins: ${totalBitcoin}`);
    if (dayOfFirstBitcoin !== 0) {
        console.log(`Day of the first purchased bitcoin: ${dayOfFirstBitcoin}`);
    }
    console.log(`Left money: ${money.toFixed(2)} lv.`)
}

bitcoinMining([3124.15, 504.212, 2511.124]);

bitcoinMining([50, 100]);

bitcoinMining([100, 200, 300]);