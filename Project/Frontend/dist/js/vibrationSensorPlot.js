// setup 
counterV = 0
labelArr = []
dataArr = []
MAX_DATA_POINTS = 120;

function addDataV(chart, data) {
    if(labelArr.length > MAX_DATA_POINTS){
        labelArr.shift();
        dataArr.shift();
    }
    chart.data.labels.push(++counterV);
    chart.data.datasets.forEach((dataset) => {
        dataset.data.push(data);
    });
    
    chart.update();
}   

const dataV = {
    labels: labelArr,
    datasets: [{
      label: 'Vibration Sensor',
      data: dataArr,
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