<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="{{ asset('styles/design.css') }}" />
    <script src="{{ asset('js/speedLimit.js') }}" defer></script> 
    <title>Config</title>
</head>
<body>
    <ul class="navbar">
        <li id="navList"><a href="/">Home</a></li>
        <li id="navList"><a href="config">Config</a></li>
        <li id="navList"><a href="sensor">Sensors</a></li>
        <li id="navList"><a href="batch">Batch</a></li>
    </ul>
    <main class="ConfigurationTab">
    <div id="inputValues">  
 
 <label for="recipeChanger">Pick a Recipe</label>  

 <select onchange="maxLimit()" id="recipeChanger">  

     <option value="pilsner" >Pilsner</option>  

     <option value="wheat">Wheat</option>  

     <option value="ipa">IPA</option>  

     <option value="stout">Stout</option>

     <option value="ale">Ale</option>

     <option value="alcoholFree">Alcohol Free</option>

 </select>

    <Label for="speed"> Pick speed</label> 
    <input id="speed" type="number" min="0" max="600" value="0"/>

    <Label for="delay"> Choose Delay if needed</label> 
    <input id="delay" type="number" min="0" value="0"/>
    
</div>  
</main>

</body>
</html>