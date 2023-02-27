function login (arr) {
    let user = arr.shift();
    let counter = 0;

    for (const pass of arr) {
        if (pass === user.split("").reverse().join("")) {
            console.log (`User ${user} logged in.`);
            return;
        } else {
            counter++;
            if(counter > 3) {
                console.log (`User ${user} blocked!`);
                return;
            }
            console.log (`Incorrect password. Try again.`);
        }
    }
}

login(['sunny','rainy','cloudy','sunny','not sunny']);