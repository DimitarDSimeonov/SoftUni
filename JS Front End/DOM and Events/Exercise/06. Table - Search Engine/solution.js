function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      let allTd = Array.from(document.querySelectorAll('tbody td'));
      let input = document.getElementById('searchField');
      let searchingText = input.value;

      for (const td of allTd) {
         if (td.textContent.includes(searchingText)){
            let tr = td.parentElement;
            tr.classList.add('select');
         }
      }
      input.value = '';

      input.addEventListener('focus', () =>{
         for (const td of allTd) {
            let tr = td.parentElement;
            tr.classList.remove('select');
         }
      });
   }
}