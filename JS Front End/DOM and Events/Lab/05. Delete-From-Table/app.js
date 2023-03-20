function deleteByEmail() {
    const input = document.querySelector('input[name="email"]');
    let inputEmail = input.value;
    const tableRows = Array.from(document.querySelectorAll('td:nth-child(even)'));
    let result = document.getElementById('result');
    let searchingEmail = tableRows.find(td => td.textContent === inputEmail);

    if(searchingEmail) {
        searchingEmail.parentElement.remove();
        result.textContent = "Deleted"
    }else {
        result.textContent = "Not found."
    }
}