function ages(age) {
    let result;
    if (0 <= age && age <= 0) {
        result = "baby";
    }else if (3 <= age && age <= 13) {
        result = "child";
    } else if (14 <= age && age <= 19) {
        result = "teenager";
    } else if (20 <= age && age <= 65) {
        result = "adult";
    } else if (age >= 66) {
        result = "elder";
    } else {
        result = "out of bounds";
    }

    console.log (result);
}