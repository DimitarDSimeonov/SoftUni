function songs(input) {

    class Song{
        constructor(type, name, time) {
            this.type = type;
            this.name = name;
            this.time = time;
        }
    }

    let songs = [];
    let numberOfSong = input.shift();
    let typeSong = input.pop();

    for(let i = 0; i < numberOfSong; i++) {
        let [type, name, time] = input[i].split("_");
        let song = new Song(type, name, time);
        songs.push(song);
    }

    if (typeSong === "all") {
        songs.forEach(s => console.log(s.name));
    }else {
        songs.filter(s => s.type === typeSong).forEach(s => console.log(s.name));
    }
}

songs(
    [2,
        'like_Replay_3:15',
        'ban_Photoshop_3:48',
        'all']
        
)