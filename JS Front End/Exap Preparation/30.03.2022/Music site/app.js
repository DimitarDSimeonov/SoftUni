window.addEventListener('load', solve);

function solve() {
    let genreInput = document.getElementById('genre');
    let nameInput = document.getElementById('name');
    let authorInput = document.getElementById('author');
    let dateInput = document.getElementById('date');
    let addBtn = document.getElementById('add-btn');

    let allHitsContainer = document.getElementsByClassName('all-hits-container')[0];
    let likeCounter = 0;
    let likeParagraph = document.querySelector('.likes p');

    addBtn.addEventListener('click', addSong)
    function addSong(e) {
        e.preventDefault();

        if (genreInput.value != '' && nameInput.value != '' &&
            authorInput.value != '' && dateInput.value != '') {

        let hitInfoDiv = document.createElement('div');
        hitInfoDiv.classList.add('hits-info');

        let img = document.createElement('img');
        img.src = './static/img/img.png';
        let genreH2 = document.createElement('h2');
        genreH2.textContent = `Genre: ${genreInput.value}`;
        let nameH2 = document.createElement('h2');
        nameH2.textContent = `Name: ${nameInput.value}`;
        let authorH2 = document.createElement('h2');
        authorH2.textContent = `Author: ${authorInput.value}`;
        let dateH3 = document.createElement('h3');
        dateH3.textContent = `Date: ${dateInput.value}`;
        let saveBtn = document.createElement('button');
        saveBtn.textContent = 'Save song';
        saveBtn.classList.add('save-btn');
        saveBtn.addEventListener('click', saveSong);
        let likeBtn = document.createElement('button');
        likeBtn.textContent = 'Like song';
        likeBtn.classList.add('like-btn');
        likeBtn.addEventListener('click', likeSong);
        let deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Delete';
        deleteBtn.classList.add('delete-btn');
        deleteBtn.addEventListener('click', deleteSong);

        hitInfoDiv.appendChild(img);
        hitInfoDiv.appendChild(genreH2);
        hitInfoDiv.appendChild(nameH2);
        hitInfoDiv.appendChild(authorH2);
        hitInfoDiv.appendChild(dateH3);
        hitInfoDiv.appendChild(saveBtn);
        hitInfoDiv.appendChild(likeBtn);
        hitInfoDiv.appendChild(deleteBtn);
        allHitsContainer.appendChild(hitInfoDiv);
        }
        
        genreInput.value = '';
        nameInput.value = '';
        authorInput.value = '';
        dateInput.value = '';

    };
    
    function likeSong (e) {
        let likeBtn = e.currentTarget;
        likeCounter++;
        likeParagraph.textContent = `Total Likes: ${likeCounter}`;
        likeBtn.disabled = true;
    }

    function deleteSong(e) {
        let btn = e.currentTarget;
        btn.parentNode.remove();
        
    }

    function saveSong(e) {
        let btn = e.currentTarget;
        let div = btn.parentNode;
        let savedSongContainer = document.getElementsByClassName('saved-container')[0];
        savedSongContainer.appendChild(div);
        let saveBtn = div.childNodes[5];
        let likeBtn = div.childNodes[6];
        div.removeChild(likeBtn);
        div.removeChild(saveBtn);

    }
}