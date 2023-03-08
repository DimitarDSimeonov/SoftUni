function passwordValidation(password) {
    let passwordIsValid = true;
    let regex = /^[A-Za-z0-9]+$/g;
    let reg = /\d/g;

    if (password.length < 6 || password.length > 10) {
        console.log (`Password must be between 6 and 10 characters`);
        passwordIsValid = false;
    }

    if (!regex.test(password)) {
        console.log (`Password must consist only of letters and digits`)
        passwordIsValid = false;
    }

    if ([...password.matchAll(reg)].length < 2) {
        console.log(`Password must have at least 2 digits`);
        passwordIsValid = false;
    }

    if (passwordIsValid) {
        console.log (`Password is valid`)
    }
}

passwordValidation ('logIn');
passwordValidation ('MyPass123');
passwordValidation ('Pa$s$s');