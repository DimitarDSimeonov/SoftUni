function attachEvents() {
    let BASE_URL = 'http://localhost:3030/jsonstore/messenger';

    let textArea = document.getElementById('messages');
    let authorInput = document.querySelectorAll('input')[0];
    let messageInput = document.querySelectorAll('input')[1];

    let sendBtn = document.getElementById('submit');
    let refreshBtn = document.getElementById('refresh');

    refreshBtn.addEventListener('click', refresh);
    sendBtn.addEventListener('click', send);

    function refresh() {
        textArea.textContent = '';
        fetch(BASE_URL)
        .then((res) => res.json())
        .then((allMsg) => {
            let messages  = Object.values(allMsg);
            let msgArr = []
            messages.forEach((m) =>{
                msgArr.push(`${m.author}: ${m.content}`);
            })

            textArea.textContent = msgArr.join('\n');
        })
    }

    function send() {
        let author = authorInput.value;
        let content = messageInput.value;
        fetch(BASE_URL, {
            method: 'post',
            body: JSON.stringify({ author, content})
        })
        .then(() =>{
            authorInput.value = '';
            messageInput.value = '';
        })
        .catch((err) =>{
            console.error(err);
        })
    }
}

attachEvents();