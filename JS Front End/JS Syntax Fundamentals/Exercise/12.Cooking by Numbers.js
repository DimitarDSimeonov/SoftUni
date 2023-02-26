function cookingByNumber(strNumber, ...operations) {
    let num = Number(strNumber);

    for (const operation of operations) {
        
        switch (operation) {
            case "chop":
                num = num / 2;
                break;
            case "dice":
                num = Math.sqrt(num);
                break;
            case "spice":
                num++;
                break;
            case "bake":
                num *= 3;
                break;
            case "fillet":
                num *= 0.8; 
                break;
        }
        console.log (num);
    }
}

cookingByNumber('32', 'chop', 'chop', 'chop', 'chop', 'chop');