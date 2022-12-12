async function inventoryStatus(){

    const response = await fetch('http://localhost:4567/machine/0/inventory').then((res) => res.json()).catch((err) => {
        console.error(err);
    })
    updateInventoryStatus(response)
}

function updateInventoryStatus(item){
    console.log(item)
    var inventoryItem = document.getElementById("")
}