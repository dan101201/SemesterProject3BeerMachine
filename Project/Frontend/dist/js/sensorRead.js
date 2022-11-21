async function func(){
/*    const Http = new XMLHttpRequest();
const url = 'http://localhost:4567/machine/0/temperature';
Http.open("GET", url);
Http.send();
Http.onreadystatechange=(e)=>{
    console.log(Http.responseText);
}*/

    const response = await fetch('http://localhost:4567/machine/0/temperature').then((res) => res.json()).catch((err) => {
        console.error(err);
    })
    console.log(response)
}

