function movies(input) {
    let filmArr = [];
    
    for(let row of input) {

        if (row.startsWith("addMovie")) {
            let name = row.slice(9);

            filmArr.push({name});

        }else if (row.includes("directedBy")) {
            let [name, director] = row.split(" directedBy ");
            let movie = filmArr.find(m => m.name === name);
            if (movie) {
                movie.director = director;
            }

        }else if (row.includes("onDate")) {
            let [name, date] = row.split(" onDate ");
            let movie = filmArr.find(m => m.name === name);
            if (movie) {
                movie.date = date;
            }
        }
    }

    for(let film of filmArr) {
        if (film.director && film.date) {
            console.log(JSON.stringify(film));
        }
    }
}
movies([
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen'
    ]
    );