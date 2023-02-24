function fruit(fruit, grams, pricePerKilogram) {
    let kg = grams / 1000;
    let price = kg * pricePerKilogram;

    console.log (`I need $${price.toFixed(2)} to buy ${kg.toFixed(2)} kilograms ${fruit}.`)
}

fruit('orange', 2500, 1.80);
fruit('apple', 1563, 2.35);