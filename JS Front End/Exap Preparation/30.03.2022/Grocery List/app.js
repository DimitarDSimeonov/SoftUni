function attachEvents() {
    let URL = 'http://localhost:3030/jsonstore/grocery/';
    let loadProductsBtn = document.getElementById('load-product');
    loadProductsBtn.addEventListener('click', loadAllProduct);

    let productInput = document.getElementById('product');
    let countInput = document.getElementById('count');
    let priceInput = document.getElementById('price');
    let addBtn = document.getElementById('add-product');
    let updateProductBtn = document.getElementById('update-product');
    addBtn.addEventListener('click', addProduct);
    
    let tbody = document.getElementById('tbody');

    updateProductBtn.addEventListener('click', updateProduct);
    let id = null;
    

    function updateProduct (e) {
        e.preventDefault();
        let product = productInput.value;
        let count = countInput.value;
        let price = priceInput.value;
        console.log(id);

        fetch(`${URL}${id}`, {
            method: 'patch',
            body: JSON.stringify({product, count, price})
        })
        .then(() => {
            productInput.value = '';
            countInput.value = '';
            price.value = '';

            addBtn.disabled = false;
            updateProductBtn.disabled = true;
            loadAllProduct(e)
        })
        } 

    function addProduct(e) {
         e.preventDefault();
        let product = productInput.value;
        let count = countInput.value;
        let price = priceInput.value;

        fetch(URL, {
            method: 'post',
            body: JSON.stringify({product, count, price}),
            headers: {'Content-type': 'application/json; charset=UTF-8'},
        })
        .then (() => {
            productInput.value = '';
            countInput.value = '';
            priceInput.value = '';
            loadAllProduct(e);
        })
    }

    function loadAllProduct(e) {
            e.preventDefault();
        tbody.innerHTML = '';
        fetch(URL)
        .then((res) => res.json())
        .then((data) => {
            let products = Object.values(data);
            products.forEach(p => {
                let tr = document.createElement('tr');
                let productTd = document.createElement('td');
                productTd.classList.add('name');
                productTd.textContent = p.product;
                let countTd = document.createElement('td');
                countTd.classList.add('count-product');
                countTd.textContent = p.count;
                let priceTd = document.createElement('td');
                priceTd.classList.add('product-price');
                priceTd.textContent = p.price;
                let buttonsTd = document.createElement('td');
                buttonsTd.classList.add('btn');
                let updateBtn = document.createElement('button');
                updateBtn.classList.add('update');
                updateBtn.textContent = 'Update';
                updateBtn.id = p._id;
                let deleteBtn = document.createElement('button');
                deleteBtn.classList.add('delete');
                deleteBtn.textContent = 'Delete';

                buttonsTd.appendChild(updateBtn);
                buttonsTd.appendChild(deleteBtn);
                tr.appendChild(productTd);
                tr.appendChild(countTd);
                tr.appendChild(priceTd);
                tr.appendChild(buttonsTd);
                tbody.appendChild(tr);
                deleteBtn.addEventListener('click', () => {
                    fetch(`${URL}${p._id}`, {
                        method: 'delete'
                    })
                    .then(() => {
                        loadAllProduct(e);
                    })
                })

                updateBtn.addEventListener('click', () => {
                    addBtn.disabled = true;
                    updateProductBtn.disabled = false;
                    id = updateBtn.id;

                    productInput.value = p.product;
                    countInput.value = p.count;
                    priceInput.value = p.price;
                })
            })
        })
    }
}
attachEvents();