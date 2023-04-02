function getInfo() {
    let BASE_URL = 'http://localhost:3030/jsonstore/bus/businfo/';
    let stopIdInput = document.getElementById('stopId');
    let stopName = document.getElementById('stopName');
    let busesUl = document.getElementById('buses');

    let stopId = stopIdInput.value;

    fetch(`${BASE_URL}${stopId}`)
    .then((res) => res.json())
    .then((currentStop) => {
        stopName.textContent = currentStop.name;
        for (const bus in currentStop.buses) {
            let li = document.createElement('li');
            li.textContent = `Bus ${bus} arrives in ${currentStop.buses[bus]} minutes`;
            busesUl.appendChild(li);
        }
    })
    .catch((err) => {
        stopName.textContent = 'Error'
    });
    // TODO:
}