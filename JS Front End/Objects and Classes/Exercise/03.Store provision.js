function storeProvision(arrOne, arrTwo) {
    let allProvision = [...arrOne, ...arrTwo];
    let store = {};

    for (let i = 0; i < allProvision.length; i += 2) {
        if (!store.hasOwnProperty(allProvision[i])) {
            store[allProvision[i]] = Number(allProvision[i + 1]);
        } else {
            store[allProvision[i]] = store[allProvision[i]] + Number(allProvision[i + 1]);
        }
    }
    for (const key in store) {
        console.log(`${key} -> ${store[key]}`)
    }
}

storeProvision([
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
    );