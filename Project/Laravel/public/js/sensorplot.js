let temperatur = "x * x+x+5";
let Humidity = "Math.sin(x)"
let Vibration = "x"
let dataSize = 50
// Generate values
const TempxValues = [];
const TempyValues = [];
const HumidxValues = [];
const HumidyValues = [];
const VibraxValues = [];
const VibrayValues = [];
for (let x = 0; x <= dataSize; x += 1) {
  TempxValues.push(x);
  TempyValues.push(eval(temperatur));
  HumidxValues.push(x);
  HumidyValues.push(eval(Humidity));
  VibraxValues.push(x);
  VibrayValues.push(eval(Vibration));
}

// Define Data
var tempData  = [{  x: TempxValues,   y: TempyValues,   mode:"lines", marker:{color:"rgb(234,153,153)"}}]
var humidData = [{  x: HumidxValues,   y: HumidyValues,   mode:"lines"}]
var vibraData = [{  x: VibraxValues,   y: VibrayValues,   mode:"lines"}]


// Display using Plotly
Plotly.newPlot("tempSensorPlot", tempData,{title: "Temperatursensor"});
Plotly.newPlot("humidSensorPlot", humidData,{title: "Humiditysensor"});
Plotly.newPlot("vibraSensorPlot", vibraData,{title: "Vibrationsensor"});