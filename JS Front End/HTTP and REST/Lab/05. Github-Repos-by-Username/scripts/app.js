function loadRepos() {
	const BASE_URL = 'https://api.github.com/users/';
	let inputUsername = document.getElementById('username');
	let username = inputUsername.value;
	let ul = document.getElementById('repos');
	ul.innerHTML = ''

	fetch(`${BASE_URL}${username}/repos`, {method: 'Get'})
	.then((res) => res.json())
	.then((data) => {
		data.forEach(element => {
			let li = document.createElement('li');
			let a = document.createElement('a');
			a.href = '#';
			a.textContent = element.full_name;
			li.appendChild(a);
			ul.appendChild(li);
		});
	})
	.catch((err) => {
		console.error(err)
	});	
}