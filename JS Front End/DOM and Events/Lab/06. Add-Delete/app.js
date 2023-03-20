function addItem() {
    const ul = document.getElementById('items');
    const inputText = document.getElementById('newItemText');

    let li = document.createElement('li');
    let a = document.createElement('a');
    a.href = '#';
    a.addEventListener('click', deleteLi);
    a.appendChild(document.createTextNode('[Delete]'));
    li.appendChild(document.createTextNode(inputText.value));
    li.appendChild(a);
    ul.appendChild(li);
    inputText.value = '';

    function deleteLi() {
        li.remove();
    }
}