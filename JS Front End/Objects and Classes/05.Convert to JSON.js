function convertToJson(name, lastName, hairColor) {
    let object = {
        name,
        lastName,
        hairColor
    };

    console.log (JSON.stringify(object));
}