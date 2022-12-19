// setup 
MAX_DATA_POINTS = 20;

function addDataH(chart, data) {
    document.getElementById('currentValHumid').innerHTML = ""+data+" %"
    if(data > 50 || data < 20){
        alert("Humidity out of threshold!");
    
      }else{
        chart.data.datasets.forEach((dataset) => {
        if (counterT > MAX_DATA_POINTS) {
          chart.data.labels.shift();
          dataset.data.shift();
        }
        dataset.data.push(data);
      });
      chart.data.labels.push(getTime());
    
      chart.update();
      }
}

const dataH = {
    labels: [],
    datasets: [{
        label: 'Humidity sensor',
        data: [],
        borderColor: "rgb(194, 13, 13)",
        backgroundColor: "rgba(194, 13, 13, 0.621)",
        borderWidth: 1
    }]
};

// config 
const configH = {
    type: 'line',
    data: dataH,
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
};

// render init block
const humidChart = new Chart(
    document.getElementById('humidChart'),
    configH
);