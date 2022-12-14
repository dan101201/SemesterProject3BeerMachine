// setup 
MAX_DATA_POINTS = 20;

function addDataV(chart, data) {
  document.getElementById('currentValVibra').innerHTML = ""+data
  chart.data.datasets.forEach((dataset) => {
    if (counterV > MAX_DATA_POINTS) {
      chart.data.labels.shift();
      dataset.data.shift();
    }
    dataset.data.push(data);
  });
  chart.data.labels.push(getTime());

  chart.update();
}   

const dataV = {
    labels: [],
    datasets: [{
      label: 'Vibration Sensor',
      data: [],
      borderColor:"rgb(194, 13, 13)",
      backgroundColor:"rgba(194, 13, 13, 0.621)",
      borderWidth: 1
    }]
  };

  // config 
  const configV = {
    type: 'line',
    data: dataV,
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  };

  // render init block
  const vibraChart = new Chart(
    document.getElementById('vibraChart'),
    configV
  );