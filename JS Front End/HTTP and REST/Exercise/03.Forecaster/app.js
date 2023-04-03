function attachEvents() {
    let LOCATION_BASE_URL = 'http://localhost:3030/jsonstore/forecaster/locations';
    let TODAY_BASE_URL = 'http://localhost:3030/jsonstore/forecaster/today/';
    let UPCOMING_BASE_URL = 'http://localhost:3030/jsonstore/forecaster/upcoming/';
    let locationInput  = document.getElementById('location');
    let divForecast = document.getElementById('forecast');
    let divCurrent = document.getElementById('current');
    let divUpcoming = document.getElementById('upcoming');

    let submitBtn = document.getElementById('submit');
    submitBtn.addEventListener('click', loadWeather);

    let code = '';

    function loadWeather() {
        fetch(`${LOCATION_BASE_URL}`)
    .then((res) => res.json())
    .then((locations) => {
        console.log(locations);
        let currentLocation = locations.find((l) => l.name === locationInput.value);
        code = currentLocation.code;

        console.log(currentLocation.code);
        fetch(`${TODAY_BASE_URL}${code}`)
        .then((res) => res.json())
        .then((toDayInfo) => {
        
        let currentConditional = toDayInfo.forecast.condition;
        let spanSymbol = document.createElement('span');
        spanSymbol.classList.add('condition');
        spanSymbol.classList.add('symbol');

        let spanContainer = document.createElement('span');
        spanContainer.classList.add('condition');

        let spanName = document.createElement('span');
        spanName.classList.add('forecast-data');
        spanName.textContent = toDayInfo.name;

        let spanDegrees = document.createElement('span');
        spanDegrees.classList.add('forecast-data');
        spanDegrees.textContent = `${toDayInfo.forecast.low}°/${toDayInfo.forecast.high}°`;

        let spanConditional = document.createElement('span');
        spanConditional.classList.add('forecast-data');
        spanConditional.textContent = toDayInfo.forecast.condition;

        spanContainer.appendChild(spanName);
        spanContainer.appendChild(spanDegrees);
        spanContainer.appendChild(spanConditional);

        if (currentConditional === 'Sunny') {
            spanSymbol.textContent = '&#x2600';
        }else if(currentConditional === 'Partly sunny') {
            spanSymbol.textContent = '&#x26C5';
        }else if(currentConditional === 'Overcast') {
            spanSymbol.textContent = '&#x2601';
        }else if (currentConditional === 'Rain') {
            spanSymbol.textContent = '&#x2614';
        }

        divCurrent.appendChild(spanSymbol);
        divCurrent.appendChild(spanContainer);

        divForecast.style.display = 'inline';
        })



        fetch(`${UPCOMING_BASE_URL}${code}`)
        .then((res) => res.json())
        .then((upcomingInfo) =>{
            let divForecastInfo = document.createElement('div');
            divForecastInfo.classList.add('forecast-info');

            upcomingInfo.forecast.forEach((day => {
                let spanContainer = document.createElement('span');
                spanContainer.classList.add('upcoming');

                let currentConditional = day.condition;
                let spanSymbol = document.createElement('span');
                spanSymbol.classList.add('symbol');
                if (currentConditional === 'Sunny') {
                    spanSymbol.textContent = '&#x2600';
                }else if(currentConditional === 'Partly sunny') {
                    spanSymbol.textContent = '&#x26C5';
                }else if(currentConditional === 'Overcast') {
                    spanSymbol.textContent = '&#x2601';
                }else if (currentConditional === 'Rain') {
                    spanSymbol.textContent = '&#x2614';
                }

                let spanDegrees = document.createElement('span');
                spanDegrees.classList.add('forecast-data');
                spanDegrees.textContent = `${day.low}°/${day.high}°`;

                let spanConditional = document.createElement('span');
                spanConditional.classList.add('forecast-data');
                spanConditional.textContent = day.condition;

                spanContainer.appendChild(spanSymbol);
                spanContainer.appendChild(spanDegrees);
                spanContainer.appendChild(spanConditional)

                divForecastInfo.appendChild(spanContainer);
            }));
            divUpcoming.appendChild(divForecastInfo);

        })

    })
    .catch((err) =>{
        console.error(err);
    });
    
    }  
}

attachEvents();