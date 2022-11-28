async function tempFunc(){

    const response = await fetch('http://localhost:4567/machine/0/temperature').then((res) => res.json()).catch((err) => {
        console.error(err);
    })
    addDataT(tempChart, response)
}

async function humidFunc(){
    const response = await fetch('http://localhost:4567/machine/0/humidity').then((res) => res.json()).catch((err) => {
        console.error(err);
})
    addDataH(humidFunc, response)
}

async function vibraFunc(){
    const response = await fetch('http://localhost:4567/machine/0/vibration').then((res) => res.json()).catch((err) => {
        console.error(err);
})
    addDataV(vibraFunc, response)
}
setInterval(async() => tempFunc(), 1000)
setInterval(async() => humidFunc(), 1000)
setInterval(async() => vibraFunc(), 1000)

