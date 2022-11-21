function func(){
    const Http = new XMLHttpRequest();
const url = 'http://localhost:4567/machine/0/temperature';
Http.open("GET", url);
Http.send();
Http.onreadystatechange=(e)=>{
    console.log(Http.responseText);
}
}

