// INVENTORY:
async function inventoryStatus(){
    const response = await fetch('http://localhost:4567/machine/0/inventory').then((res) => res.json()).catch((err) => {
        console.error(err);
    });
    updateInventoryStatus(response[0], "barley");
    updateInventoryStatus(response[1], "hops");
    updateInventoryStatus(response[2], "malt");
    updateInventoryStatus(response[3], "wheat");
    updateInventoryStatus(response[4], "yeast");
}

function updateInventoryStatus(item, ingredientName){
    var invItem = document.getElementById(ingredientName)
    invItem.style.height = 35000/item*100+"%"
    console.log(getDate());
}

// CURRENT BATCHES:
async function updateCurrentBatch(){
    const responseGood = await fetch('http://localhost:4567/machine/0/batch/good').then((res) => res.json()).catch((err) => {
        console.error(err);
    });
    const responseBad = await fetch('http://localhost:4567/machine/0/batch/bad').then((res) => res.json()).catch((err) => {
        console.error(err);
    });
    const responseProduced = await fetch('http://localhost:4567/machine/0/batch/produced').then((res) => res.json()).catch((err) => {
        console.error(err);
    });
    const responseAmount= await fetch('http://localhost:4567/machine/0/batch/produce_amount').then((res) => res.json()).catch((err) => {
        console.error(err);
    });

    updateCurrentBatchTable(responseProduced, responseGood, responseBad, responseAmount);
}








setInterval(async() => updateCurrentBatch(), 3000)
setInterval(async() => inventoryStatus(), 3000)


