<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="{{ asset('styles/primary_design.css') }}" />
    <link rel="stylesheet" href="{{ asset('styles/sensorpage_design.css') }}" />
    <link rel="stylesheet" href="{{ asset('styles/primary_design.css') }}" />
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <script src="{{ asset('js/sensorplot.js') }}" defer></script>
    <title>Sensor data</title>
</head>

<body>
    <ul class="navbar">
        <img src="{{ asset('img/sdu_logo_uwu.png') }}" alt="LOGO" id="logo">
        <li id="navList"><a href="/">Home</a></li>
        <li id="navList"><a href="config">Config</a></li>
        <li id="navList"><a href="sensor">Sensors</a></li>
        <li id="navList"><a href="batch">Batch</a></li>
    </ul>
    <div id="tempSensorPlot" class="plot"> </div>
    <div id="humidSensorPlot" class="plot"> </div>
    <div id="vibraSensorPlot" class="plot"> </div>
</body>

</html>