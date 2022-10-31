<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="{{ asset('styles/design.css') }}" />
    <title>Homepage</title>
</head>
<body>
    <ul class="navbar">
        <li id="navList"><a href="/">Home</a></li>
        <li id="navList"><a href="config">Config</a></li>
        <li id="navList"><a href="sensor">Sensors</a></li>
        <li id="navList"><a href="batch">Batch</a></li>
    </ul>
    <main class="sections">
        <div id="button_group">
            <button>Start</button>
            <button>Stop</button>
            <button>Abort</button>
            <button>Clear</button>
        </div>
        <div id="inventory">
            <progress id="barley" value="50" max="100"></progress>
            <progress id="hops" value="50" max="100"></progress>
            <progress id="malt" value="50" max="100"></progress>
            <progress id="wheat" value="50" max="100"></progress>
            <progress id="yeast" value="50" max="100"></progress>
        </div>
        
    </main>
</body>
</html>
