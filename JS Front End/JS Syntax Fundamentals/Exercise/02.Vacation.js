function vacation(countPeople, groupType, day) {
    let price = 0;

    switch (day) {
        case "Friday":
            switch (groupType) {
                case "Students":
                    price = countPeople * 8.45;
                    if (countPeople >= 30) {
                        price *= 0.85;
                    }
                    break;
                case "Business":
                    price = countPeople * 10.90;
                    if (countPeople >= 100) {
                        price = (countPeople - 10) * 10.90;
                    }
                    break;
                case "Regular":
                    price = countPeople * 15;
                    if (countPeople >= 10 && countPeople <= 20) {
                        price *= 0.95;
                    }
                    break;
            }
            break;

        case "Saturday":
            switch (groupType) {
                case "Students":
                    price = countPeople * 9.80;
                    if (countPeople >= 30) {
                        price *= 0.85;
                    }
                    break;
                case "Business":
                    price = countPeople * 15.60;
                    if (countPeople >= 100) {
                        price = (countPeople - 10) * 15.60;
                    }
                    break;
                case "Regular":
                    price = countPeople * 20;
                    if (countPeople >= 10 && countPeople <= 20) {
                        price *= 0.95;
                    }
                    break;
            }
            break;

        case "Sunday":
            switch (groupType) {
                case "Students":
                    price = countPeople * 10.46;
                    if (countPeople >= 30) {
                        price *= 0.85;
                    }
                    break;
                case "Business":
                    price = countPeople * 16;
                    if (countPeople >= 100) {
                        price = (countPeople - 10) * 16;
                    }
                    break;
                case "Regular":
                    price = countPeople * 22.50;
                    if (countPeople >= 10 && countPeople <= 20) {
                        price *= 0.95;
                    }
                    break;
            }
            break;
    }

    console.log (`Total price: ${price.toFixed(2)}`);
}

vacation(
    30,
"Students",
"Sunday"
);

vacation(
    40,
    "Regular",
    "Saturday"      
);

vacation (
    100,
    "Business",
    "Sunday"
);