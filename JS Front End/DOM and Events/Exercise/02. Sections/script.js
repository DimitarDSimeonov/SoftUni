function create(words) {
   const content = document.getElementById('content');

   for (const word of words) {
      let paragraph = document.createElement('p');
      paragraph.textContent = word;
      paragraph.style.display = 'none';

      let div = document.createElement('div');
      div.appendChild(paragraph);
      div.addEventListener('click', () => paragraph.style.display = 'block');

      content.appendChild(div);
   }
}