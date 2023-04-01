function loadCommits() {
    let BASE_URL = 'https://api.github.com/repos/';
    let inputUsername = document.getElementById('username');
    let username = inputUsername.value;
    let inputRepo = document.getElementById('repo');
    let repo = inputRepo.value;
    let ul = document.getElementById('commits');
    ul.innerHTML = ''

    fetch(`${BASE_URL}${username}/${repo}/commits`)
    .then((res) => res.json())
    .then((data) => {
        data.forEach(element => {
            let li = document.createElement('li');
            li.textContent = `${element.commit.author.name}: ${element.commit.message}`
            ul.appendChild(li);
        });
    })
    .catch((err) => {
        let li = document.createElement('li');
        li.textContent = `Error: 404 (Not Found)`;
        ul.appendChild(li);
    });   
}