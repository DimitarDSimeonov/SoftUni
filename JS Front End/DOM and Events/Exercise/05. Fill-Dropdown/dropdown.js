function addItem() {
    let inputText = document.getElementById('newItemText');
    let inputValue = document.getElementById('newItemValue');
    let select = document.getElementById('menu');

    let option = document.createElement('option');
    option.value = inputValue.value;
    option.text = inputText.value;

    select.appendChild(option);

    inputText.value = '';
    inputValue.value = '';
}