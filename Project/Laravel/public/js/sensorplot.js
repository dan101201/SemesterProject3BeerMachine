let temperatur = "x * x+x+5";
let Humidity = "x+2"
let Vibration = "x"
let dataSize = 10
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
const data = [
    {  x: TempxValues,   y: TempyValues,   mode:"lines"},
    {  x: HumidxValues,   y: HumidyValues,   mode:"lines"},
    {  x: VibraxValues,   y: VibrayValues,   mode:"lines"}

];

function displayData(){
    var plot = document.getElementById("plotOptions")
    var sensors = plot.getElementsByTagName("input")
    for(var i = 0; i < sensors.length; i++){
        if(sensors[i].type === 'checkbox'){
            products[i].onclick = updatePlot;
        }
    }
}   

function updatePlot(){
    var myForm = this.form

}


// Display using Plotly
Plotly.newPlot("sensorPlot", data);