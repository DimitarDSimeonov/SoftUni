function extractText() {
    const liArr = document.querySelectorAll("li");
    const text = document.getElementById("result");

    for (const li of liArr) {
        text.value += li.textContent + "\n"
    }
}