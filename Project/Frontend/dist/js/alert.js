let button = document.getElementById("StartButton");

button.addEventListener('click', () => {
    checkAmount();
})

function checkAmount(){

    alertNotification("barley");
    alertNotification("hops");
    alertNotification("malt");
    alertNotification("wheat");
    alertNotification("yeast");
}


function alertNotification(ingredient){
    var amount = document.getElementById(ingredient).value;
    let minimum = 50;
    if (amount < minimum){
        alert("Amount of " + ingredient + " is getting low! Please fix");
    }
};
