function shoppingList(input) {
    let products = input.shift();
    let productArr = [];
    products.split('!').forEach(element => {
        productArr.push(element);
    });

    for (const row of input) {
        let command = row.split(' ')[0];
        let product = row.split(' ')[1];

        switch(command) {
            case "Urgent":
               if (!productArr.includes(product)) {
                productArr.unshift(product);
               }
            break;
            case "Unnecessary":
                if (productArr.includes(product)) {
                let indexOfProduct = productArr.indexOf(product);
                productArr.splice(indexOfProduct, 1);
                }
            break;
            case "Correct":
                let newProduct = row.split(' ')[2];
                if (productArr.includes(product)) {
                    let indexOfProduct = productArr.indexOf(product);
                    productArr[indexOfProduct] = newProduct;
                }
            break;
            case "Rearrange":
                if (productArr.includes(product)) {
                    let indexOfProduct = productArr.indexOf(product);
                    productArr.splice(indexOfProduct, 1);
                    productArr.push(product);
                }
            break;
            case "Go":
            return console.log(productArr.join(', '));
        }

    }
}

shoppingList(["Tomatoes!Potatoes!Bread",
"Unnecessary Milk",
"Urgent Tomatoes",
"Go Shopping!"]);

shoppingList(["Milk!Pepper!Salt!Water!Banana",
"Urgent Salt",
"Unnecessary Grapes",
"Correct Pepper Onion",
"Rearrange Grapes",
"Correct Tomatoes Potatoes",
"Go Shopping!"]);

