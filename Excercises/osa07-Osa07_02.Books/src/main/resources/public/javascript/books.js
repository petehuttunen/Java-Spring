var url = contextRoot + "books/random"

var http = new XMLHttpRequest()

http.onreadystatechange = function() {
    if (this.readyState != 4 || this.status != 200) {
        return
    }

    var book = JSON.parse(this.responseText)
    document.getElementById("title").innerHTML = book.title;
    document.getElementById("author").innerHTML = book.author;
    document.getElementById("pages").innerHTML = book.pages;
}

function getRandomBook() {
    http.open("GET", url);
    http.send();
}

// Implement the functionality to retrieve a random book here

