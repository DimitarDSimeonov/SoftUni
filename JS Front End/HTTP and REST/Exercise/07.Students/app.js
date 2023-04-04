function attachEvents() {
  let URL = 'http://localhost:3030/jsonstore/collections/students';

  let tbody = document.getElementsByTagName('tbody')[0];
  let firstNameInput = document.querySelectorAll('input')[0];
  let lastNameInput = document.querySelectorAll('input')[1];
  let facultyNumberInput = document.querySelectorAll('input')[2];
  let gradeInput = document.querySelectorAll('input')[3];

  let submitBtn = document.getElementById('submit');
  submitBtn.addEventListener('click', createStudent);

  loadStudents();

  function loadStudents() {

    tbody.innerHTML = '';
    fetch(URL)
    .then((res) => res.json())
    .then((data) => {
      let students = Object.values(data);

      students.forEach((s) => {
        let tr = document.createElement('tr');

        let tdFirstName = document.createElement('td');
        tdFirstName.textContent = s.firstName;
        tr.appendChild(tdFirstName);

        let tdLastName = document.createElement('td');
        tdLastName.textContent = s.lastName;
        tr.appendChild(tdLastName);

        let tdFacultyNumber = document.createElement('td');
        tdFacultyNumber.textContent = s.facultyNumber;
        tr.appendChild(tdFacultyNumber);

        let tdGrade = document.createElement('td');
        tdGrade.textContent = s.grade;
        tr.appendChild(tdGrade);

        tbody.appendChild(tr);
      })
    })
  }


  function createStudent() {
    if (firstNameInput.value !== '' && lastNameInput.value !== '' &&
       gradeInput.value !== '' && facultyNumberInput.value !=='') {
        
        let firstName = firstNameInput.value;
        let lastName = lastNameInput.value;
        let facultyNumber = facultyNumberInput.value;
        let grade = gradeInput.value;

        fetch(URL, {
          method: 'post',
          body: JSON.stringify({firstName, lastName, facultyNumber, grade})
        })
        .then(() => {
          loadStudents();
        })
       }
       firstNameInput.value = '';
       lastNameInput.value = '';
       facultyNumberInput.value = '';
       gradeInput.value = '';
  }
}

attachEvents();