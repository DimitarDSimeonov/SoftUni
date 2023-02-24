function leapYer (year) {
    let result;
    if ((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0) {
        result = "yes";
    }else {
        result = "no"
    }
    console.log (result);
}

leapYer (2003);
leapYer (1984);