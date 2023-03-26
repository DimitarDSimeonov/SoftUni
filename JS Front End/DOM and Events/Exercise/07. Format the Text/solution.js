function solve() {
  let input = document.getElementById('input');
  let outputDiv = document.getElementById('output');

  let text = input.value.split('.');
  text.pop();

  while(text.length > 0) {
  let paragraphText = text.splice(0, 3).map(e => e.trimStart());
  let p = document.createElement('p');
  p.textContent = paragraphText.join('.') + '.';
  outputDiv.appendChild(p);
  }
}