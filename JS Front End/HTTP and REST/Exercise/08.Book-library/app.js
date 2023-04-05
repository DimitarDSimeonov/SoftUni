function attachEvents() {
  let URL = 'http://localhost:3030/jsonstore/collections/books/';
  let loadBooksBtn = document.getElementById('loadBooks');
  let tbody = document.querySelector('table > tbody');

  let [titleInput, authorInput] = Array.from(document.querySelectorAll('#form > input'));
  let submitBtn = document.querySelector('#form > button');
  let formTitle = document.querySelector('#form > h3');

  let editBookId = null;

  loadBooksBtn.addEventListener('click', loadAllBooks);
  submitBtn.addEventListener('click', createBook);

  function createBook() {
    let title = titleInput.value;
    let author = authorInput.value;

    if(submitBtn.textContent === 'Submit') {
      fetch(URL,{
        method: 'post',
        body: JSON.stringify({title, author})
      })
      .then(() => {
        loadAllBooks();
        titleInput.value = '';
        authorInput.value = '';
      })
    }else if (submitBtn.textContent === 'Save') {
      fetch(`${URL}${editBookId}`,{
        method: 'put',
        body: JSON.stringify({title, author})
      })
      .then(() => {
        loadAllBooks();
        titleInput.value = '';
        authorInput.value = '';
        submitBtn.textContent = 'Submit';
        formTitle.textContent = 'Form';
      })
    }
  }

  function loadAllBooks() {
    tbody.innerHTML = '';
    fetch(URL)
    .then((res) => res.json())
    .then((books) => {
      for (const bookId in books) {
        let { title, author} = books[bookId];
        let tr = document.createElement('tr');
        let authorTd = document.createElement('td');
        let titleTd = document.createElement('td');
        let buttonsTd = document.createElement('td');
        let editBtn = document.createElement('button');
        let deleteBtn = document.createElement('button');

        editBtn.textContent = 'Edit';
        deleteBtn.textContent = 'Delete';
        deleteBtn.id = bookId;
        buttonsTd.appendChild(editBtn);
        buttonsTd.appendChild(deleteBtn);

        authorTd.textContent = author;
        titleTd.textContent = title;

        tr.appendChild(titleTd);
        tr.appendChild(authorTd);
        tr.appendChild(buttonsTd);
        tbody.appendChild(tr);

        deleteBtn.addEventListener('click', deleteBook);
        editBtn.addEventListener('click', () => {
          editBookId = bookId;
          formTitle.textContent = 'Edit FORM';
          submitBtn.textContent = 'Save';
          titleInput.value = title;
          authorInput.value = author;
        });
      }
    })
  }

  function deleteBook() {
    let id = this.id;

    fetch(`${URL}${id}`, {
      method: 'delete'
    })
    .then(() => {
      loadAllBooks();
    })
  }
}

attachEvents();