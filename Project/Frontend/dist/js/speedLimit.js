var speed;
let recipe;
function maxLimit(){
    recipe = document.getElementById("recipeChanger");
    speed = document.getElementById("speed");
    switch (recipe.value){
        case "0":
            speed.setAttribute("max", 600);
            speed.value = Math.min(speed.value, 600);
            break;
        case "1":
            speed.setAttribute("max", 300);
            speed.value = Math.min(speed.value, 300);
            break;
        case "2":
            speed.setAttribute("max", 150);
            speed.value = Math.min(speed.value, 150);
            break;
        case "3":
            speed.setAttribute("max", 200);
            speed.value = Math.min(speed.value, 200);
            break;
        case "4":
            speed.setAttribute("max", 100);
            speed.value = Math.min(speed.value, 100);
            break;
        case "5":
            speed.setAttribute("max", 125);
            speed.value = Math.min(speed.value, 125);
            break;
        default:
            console.log("error");
    }

    fetch(`http://localhost:4567/machine/0/command/speed/${recipe.value}/${speed.value}/`).then((res) => {
        console.log(res);
        if (res.ok) { 
            console.log("Command sent");
        } else {
            alert("")
        }
    }).catch((err) => {
        console.error(err);
    });
}
var rs;
function getRecipe(){
    var r = document.getElementById("recipeChanger");
    switch(r.value){
        case "0":
            rs = "Pilsner"
            break;
        case "1":
            rs = "Wheat"
            break;
        case "2":
            rs = "IPA"
            break;
        case "3":
            rs = "Stout"
            break;
        case "4":
            rs = "Ale"
            break;
        case "5":
            rs = "Alcohol free"
            break;
    }
    return rs;
}
function getSpeed(){
    return document.getElementById("speed").value;
}