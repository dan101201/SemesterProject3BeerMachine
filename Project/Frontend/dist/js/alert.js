let button = document.getElementById("StartButton");

button.addEventListener('click', () => {
    let arrayBooleans = [];
    arrayBooleans.push(alertNotification("barley"));
    arrayBooleans.push(alertNotification("hops"));
    arrayBooleans.push(alertNotification("malt"));
    arrayBooleans.push(alertNotification("wheat"));
    arrayBooleans.push(alertNotification("yeast"));
    
    if(arrayBooleans.includes(false)){
        console.log("Jeg fandt en fejl"); // Hvis den finder mindst en fejl, så lader den være med at køre. (Her kører vi så "printer logik" altså¨det kan godt var den givne opskrift ikke bruger en bestemt ingredient som er ved at løbe tør, men programmet vil stadig ikke starte uden)
    } else{
        console.log("Ingen fejl her makker :)"); // Hvis ingen fejl, så er det her den så sender request'en om at lave et batch videre til maskinen.
        commandStart();
    }

    maintainanceAlert()
})


// Har gjort sådan at den returnere en boolean, så man også kan bruge den til at forhindre kode.
function alertNotification(ingredient){
    var amount = document.getElementById(ingredient);
    amount = amount.style.height.slice(0,-1);
    let minimum = 50;
    if (amount < minimum){
        addToWarningTable("Amount of "+ingredient+" is getting low!", getDate(), 1)
        alert("Amount of " + ingredient + " is getting low! Please fix");
        return false;
    }
    return true;
}

function maintainanceAlert(){
    var timer = document.getElementById("maintain");
    timer = timer.style.height.slice(0,1);
    if (timer <= 20){
        addToWarningTable("Machine is in need of fixing", getDate(), 1)
        alert("Machine is in need of fixing");
        return false;
    }
    return true;
}

function testAlrt(){
    alert()
}
