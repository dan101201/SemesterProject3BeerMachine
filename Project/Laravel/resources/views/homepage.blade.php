<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="{{ asset('styles/primary_design.css') }}" />
    <link rel="stylesheet" href="{{ asset('styles/homepage_design.css') }}" />
    <title>Homepage</title>
</head>

<body>
    <ul class="navbar">
        <img src="{{ asset('img/sdu_logo_uwu.png') }}" alt="LOGO" id="logo">
        <li id="navList"><a href="/">Home</a></li>
        <li id="navList"><a href="config">Config</a></li>
        <li id="navList"><a href="sensor">Sensors</a></li>
        <li id="navList"><a href="batch">Batch</a></li>
    </ul>
    <main class="sections">
        <div id="button_group">
            <button>Start</button><br>
            <button>Stop</button> <br>
            <button>Abort</button><br>
            <button>Clear</button><br>
        </div>
        <div id="inventory">
            <progress id="barley" value="50" max="100"></progress>
            <progress id="hops" value="25" max="100"></progress>
            <progress id="malt" value="50" max="100"></progress>
            <progress id="wheat" value="70" max="100"></progress>
            <progress id="yeast" value="90" max="100"></progress>
            <progress id="maintain" value="50" max=100></progress>
        </div>
        <div id="warning_table">
            <div id="scroll_table">
                <table>
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Warning</td>
                            <td>Timestamp</td>
                            <td>Machine number</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>0</td>
                            <td>lorem50</td>
                            <td>07-11-2022</td>
                            <td>Machine number</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </main>

</body>

</html>