function attachEvents() {
    let BASE_URL = 'http://localhost:3030/jsonstore/phonebook';

    let ul = document.getElementById('phonebook');
    let loadBtn = document.getElementById('btnLoad');
    loadBtn.addEventListener('click', loadContacts);

    let contacts = [];

    function loadContacts() {
        ul.innerHTML = '';
        fetch(BASE_URL)
        .then((res) => res.json())
        .then((data) => {
            contacts = Object.values(data);
            
            contacts.forEach((c) =>{
                let deleteBtn = document.createElement('button');
                deleteBtn.textContent = 'Delete';
                deleteBtn.addEventListener('click', () =>{
                    fetch(`${BASE_URL}/${c._id}`, {method: 'delete'})
                    .then(() =>{
                        loadContacts();
                    })
                    
                });

                let li = document.createElement('li');
                li.textContent = `${c.person}: ${c.phone}`
                li.appendChild(deleteBtn);

                ul.appendChild(li);

            })
        })
        .catch((err) => {
            console.error(err);
        })
    }

    let inputName = document.getElementById('person');
    let inputPhone = document.getElementById('phone');
    let createBtn = document.getElementById(`btnCreate`);
    createBtn.addEventListener('click', createContact);

    function createContact() {
        let person = inputName.value;
        let phone = inputPhone.value;
        fetch(BASE_URL, {
            method: 'post',
            headers: {'Content-type': 'application/json'},
            body: JSON.stringify({person, phone})
        })
        .then(() => {
            inputName.value = '';
            inputPhone.value = '';
            loadContacts();
        })
    }
}

attachEvents();