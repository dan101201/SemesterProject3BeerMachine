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

setInterval(async() => inventoryStatus(), 300000)