// SENSORS:
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
    addDataH(humidChart, response)
}

async function vibraFunc(){
    const response = await fetch('http://localhost:4567/machine/0/vibration').then((res) => res.json()).catch((err) => {
        console.error(err);
})
    addDataV(vibraChart, response)
}
// INVENTORY:
async function inventoryStatus(){
    const response = await fetch('http://localhost:4567/machine/0/inventory').then((res) => res.json()).catch((err) => {
        console.error(err);
    })
    updateInventoryStatus(response[0], "barley")
    updateInventoryStatus(response[1], "hops")
    updateInventoryStatus(response[2], "malt")
    updateInventoryStatus(response[3], "wheat")
    updateInventoryStatus(response[4], "yeast")

}

function updateInventoryStatus(item, itemName){
    var invItem = document.getElementById(itemName)
    invItem.style.height = 35000/item*100+"%"
    console.log(getDate());
}

// CURRENT BATCHES:
async function updateCurrentBatch(){
    const responseGood = await fetch('http://localhost:4567/machine/0/batch/good').then((res) => res.json()).catch((err) => {
        console.error(err);
    })
    const responseBad = await fetch('http://localhost:4567/machine/0/batch/bad').then((res) => res.json()).catch((err) => {
        console.error(err);
    })
    const responseProduced = await fetch('http://localhost:4567/machine/0/batch/produced').then((res) => res.json()).catch((err) => {
        console.error(err);
    })
    const responseAmount= await fetch('http://localhost:4567/machine/0/batch/produce_amount').then((res) => res.json()).catch((err) => {
        console.error(err);
    })

    updateCurrentBatch(responseProduced, responseGood, responseBad, responseAmount, getDate())
}








setInterval(async() => updateCurrentBatch(), 3000)
setInterval(async() => inventoryStatus(), 3000)
setInterval(async() => tempFunc(), 1000)
setInterval(async() => humidFunc(), 1000)
setInterval(async() => vibraFunc(), 1000)

