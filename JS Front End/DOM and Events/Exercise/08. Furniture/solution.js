function solve() {
  let [generateTextArea, buyTextArea] = Array.from(document.getElementsByTagName('textarea'));
  let [generateBtn, buyBtn] = Array.from(document.getElementsByTagName('button'));

  let tbody = document.querySelector('.table > tbody');

  generateBtn.addEventListener('click', generate);
  buyBtn.addEventListener('click', buy);

  function generate() {
    let data = JSON.parse(generateTextArea.value);

    for (const { img, name, price, decFactor } of data) {
      let tableRow = createElement('tr', '', tbody);
      let firstColumnTd = createElement('td', '', tableRow);
      createElement('img', '', firstColumnTd, '', '', {src: img});
      let secondColumnTd = createElement('td', '', tableRow);
      createElement('p', name, secondColumnTd);
      let thirdColumnTd = createElement('td', '', tableRow);
      createElement('p', price, thirdColumnTd);
      let fourthColumnTd = createElement('td', '', tableRow);
      createElement('p',decFactor, fourthColumnTd);
      let fifthColumnTd = createElement('td', '', tableRow);
      createElement('input', '',fifthColumnTd, '', '', {type: 'checkbox'});
    }
  }

  function buy() {
    let checkedInputs = Array.from(document.querySelectorAll('tbody tr input:checked'));
  
    let items = [];
    let totalPrice = 0;
    let decorationFactor = 0;
  
    for (const input of checkedInputs) {
      let tableRow = input.parentElement.parentElement;
      let [firstColumn, secondColumn, thirdColumn, fourthColumn] = Array.from(tableRow.children);
  
      let item = secondColumn.children[0].textContent;
      items.push(item);
      let currentPrice = Number(thirdColumn.children[0].textContent);
      totalPrice += currentPrice;
      let currentDecorationFactor = Number(fourthColumn.children[0].textContent);
      decorationFactor += currentDecorationFactor;
    }

    buyTextArea.value += `Bought furniture: ${items.join(', ')}\n`;
    buyTextArea.value += `Total price: ${totalPrice.toFixed(2)}\n`;
    buyTextArea.value += `Average decoration factor: ${decorationFactor/checkedInputs.length}`;
  }

  function createElement(type, content, parenNode, id, classes, attributes) {
    let element = document.createElement(type);
  
    if( content && type !== 'input') {
      element.textContent = content;
    }
  
    if (content && type === 'input') {
      element.value = content;
    }
  
    if (parenNode) {
      parenNode.appendChild(element);
    }
  
    if (id) {
      element.id = id;
    }
  
    if (classes) {
      element.classList.add(...classes);
    }
  
    if (attributes) {
      for (const key in attributes) {
        element.setAttribute(key, attributes[key]);
      }
    }
  
    return element;
  }
}


