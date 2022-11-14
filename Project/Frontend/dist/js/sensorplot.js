// setup 
counter = 0
labeltest = []
datatest = []
MAX_DATA_POINTS = 20;

function addData(chart, data) {
    if(labeltest.length > MAX_DATA_POINTS){
        labeltest.shift();
        datatest.shift();
    }
    chart.data.labels.push(++counter);
    chart.data.datasets.forEach((dataset) => {
        dataset.data.push(data);
    });
    
    chart.update();
}

const data = {
    labels: labeltest,
    datasets: [{
      label: 'Temperatur Sensor',
      data: datatest,
      borderColor:"rgb(194, 13, 13)",
      backgroundColor:"rgba(194, 13, 13, 0.621)",
      borderWidth: 1
    }]
  };

  // config 
  const config = {
    type: 'line',
    data,
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  };

  // render init block
  const myChart = new Chart(
    document.getElementById('myChart'),
    config
  );