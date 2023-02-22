function solve(day, age) {
    let result;

    switch (day) {
        case "Weekday":
            if (0 <= age && age <= 18) {
                result = "12$";
            }else if (18 < age && age <= 64) {
                result = "18$";
            }else if (64 < age && age <= 122) {
                result = "12$"
            }else {
                result = "Error!"
            }
            break;
        case "Weekend":
            if (0 <= age && age <= 18) {
                result = "15$";
            }else if (18 < age && age <= 64) {
                result = "20$";
            }else if (64 < age && age <= 122) {
                result = "15$"
            }else {
                result = "Error!"
            }
            break;
        case "Holiday":
            if (0 <= age && age <= 18) {
                result = "5$";
            }else if (18 < age && age <= 64) {
                result = "12$";
            }else if (64 < age && age <= 122) {
                result = "10$"
            }else {
                result = "Error!"
            }
            break;
        default:
            result = "Error!"
    }

    console.log (result);
}