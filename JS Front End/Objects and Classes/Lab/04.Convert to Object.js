function convertToObject(jsonStr) {
    let object = JSON.parse(jsonStr);
    
    for (const key in object) {
        console.log (`${key}: ${object[key]}`);
    }
}

convertToObject('{"name": "George", "age": 40, "town": "Sofia"}');