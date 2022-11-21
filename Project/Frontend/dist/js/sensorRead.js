async function tempFunc(){

    const response = await fetch('http://localhost:4567/machine/0/temperature').then((res) => res.json()).catch((err) => {
        console.error(err);
    })
    addDataT(tempChart, response)
}

setInterval(async() => tempFunc(), 1000)

