function solve() {
    let BASE_URL = 'http://localhost:3030/jsonstore/bus/schedule/';
    let departBtn = document.getElementById('depart');
    let arriveBtn = document.getElementById('arrive');
    let spanInfo = document.querySelector('span');

    let nextStop = 'depot';
    let stopName = '';
    function depart() {
        fetch(`${BASE_URL}${nextStop}`)
        .then((res) => res.json())
        .then((stop) => {
            stopName = stop.name;
            spanInfo.textContent = `Next stop ${stopName}`
            departBtn.disabled = true;
            arriveBtn.disabled = false;
            nextStop = stop.next;
        })
        .catch((err) => {
            console.error(err);
        });
        // TODO: 
    }

    async function arrive() {
        spanInfo.textContent = `Arriving at ${stopName}`;
        departBtn.disabled = false;
        arriveBtn.disabled = true;
        // TODO:
    }

    return {
        depart,
        arrive
    };
}

let result = solve();