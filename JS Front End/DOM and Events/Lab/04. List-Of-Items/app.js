function addItem() {
    const ul = document.getElementById("items");
    const newItem = document.getElementById("newItemText");
    let li = document.createElement("li");
    li.appendChild(document.createTextNode(newItem.value));

    ul.appendChild(li)
    newItem.value = "";
}