function roadRadar(speed, zone) {
    let output;
    let speedLimit = 0;

    switch (zone) {
        case "residential":
            speedLimit = 20;
            if (speed <= speedLimit) {
                output = `Driving ${speed} km/h in a ${speedLimit} zone`
            } else {
                let difference = speed - speedLimit;
                let status;

                if (difference <= 20) {
                    status = "speeding";
                } else if (difference <= 40) {
                    status = "excessive speeding"
                } else {
                    status = "reckless driving"
                }
                output = `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - ${status}`
            }
            break;

        case "city":
            speedLimit = 50;
            if (speed <= speedLimit) {
                output = `Driving ${speed} km/h in a ${speedLimit} zone`
            } else {
                let difference = speed - speedLimit;
                let status;

                if (difference <= 20) {
                    status = "speeding";
                } else if (difference <= 40) {
                    status = "excessive speeding"
                } else {
                    status = "reckless driving"
                }
                output = `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - ${status}`
            }
            break;

        case "interstate":
            speedLimit = 90;
            if (speed <= speedLimit) {
                output = `Driving ${speed} km/h in a ${speedLimit} zone`
            } else {
                let difference = speed - speedLimit;
                let status;

                if (difference <= 20) {
                    status = "speeding";
                } else if (difference <= 40) {
                    status = "excessive speeding"
                } else {
                    status = "reckless driving"
                }
                output = `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - ${status}`
            }
            break;

        case "motorway":
            speedLimit = 130;
            if (speed <= speedLimit) {
                output = `Driving ${speed} km/h in a ${speedLimit} zone`
            } else {
                let difference = speed - speedLimit;
                let status;

                if (difference <= 20) {
                    status = "speeding";
                } else if (difference <= 40) {
                    status = "excessive speeding"
                } else {
                    status = "reckless driving"
                }
                output = `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - ${status}`
            }
            break;
    }
    console.log(output);
}