function maxLimit(){
    document.getElementById("speed").value = 0;
    document.getElementById("delay").value = 0;
    let recipe = document.getElementById("recipeChanger").value;
    var speed = document.getElementById("speed");
    console.log(recipe);
    switch (recipe){
        case "pilsner":
            speed.setAttribute("max",600);
            //document.getElementById("speed").setAttribute("max",600);
            break;
        case "wheat":
            speed.setAttribute("max",300);
            break;
        case "ipa":
            speed.setAttribute("max",150);
            break;
        case "stout":
            speed.setAttribute("max",200);
            break;
        case "ale":
            speed.setAttribute("max",100);
            break;
        case "alcoholFree":
            speed.setAttribute("max",125);
            break;
        
    }
}