function maxLimit(){
    //document.getElementById("speed").value = 0;
    //document.getElementById("delay").value = 0;
    let recipe = document.getElementById("recipeChanger");
    var speed = document.getElementById("speed");
    console.log(recipe.value);
    switch (recipe.value){
        case "0":
            speed.setAttribute("max", 600);
            speed.value = Math.min(speed.value, 600);
            console.log("max speed is 600");
            break;
        case "1":
            speed.setAttribute("max", 300);
            speed.value = Math.min(speed.value, 300);
            console.log("max speed is 300");
            break;
        case "2":
            speed.setAttribute("max", 150);
            speed.value = Math.min(speed.value, 150);
            console.log("max speed is 150");
            break;
        case "3":
            speed.setAttribute("max", 200);
            speed.value = Math.min(speed.value, 200);
            console.log("max speed is 200");
            break;
        case "4":
            speed.setAttribute("max", 100);
            speed.value = Math.min(speed.value, 100);
            console.log("max speed is 100");
            break;
        case "5":
            speed.setAttribute("max", 125);
            speed.value = Math.min(speed.value, 125);
            console.log("max speed is 125");
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
