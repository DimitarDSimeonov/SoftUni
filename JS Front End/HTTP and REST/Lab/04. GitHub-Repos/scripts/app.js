function loadRepos() {
   const BASE_URL = 'https://api.github.com/users/testnakov/repos';
   let result = document.getElementById('res');
   
   fetch(BASE_URL, { method: 'GET'})
   .then((res) => res.text())
   .then((data) => {
      result.textContent = data;
   })
   .catch((err) => {
      console.error(err);
   })
}