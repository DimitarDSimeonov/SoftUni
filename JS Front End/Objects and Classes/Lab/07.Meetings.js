function meetings(input) {
    let meetings = {};

    for (let row of input) {
        let [day, name] = row.split(" ");

        if(meetings.hasOwnProperty(day)){
            console.log(`Conflict on ${day}!`);
        } else {
            meetings[day] = name;
            console.log(`Scheduled for ${day}`);
        }
    }

    let keys = Object.keys(meetings);
    for (let key of keys) {
        console.log(`${key} -> ${meetings[key]}`);
    }
}

meetings(['Monday Peter',
'Wednesday Bill',
'Monday Tim',
'Friday Tim']
);