// setup 
counterT = 0
labelArr = []
dataArr = []
MAX_DATA_POINTS = 120;

function addDataT(chart, data) {
    if(labelArr.length > MAX_DATA_POINTS){
        console.log("test");
        labelArr.shift();
        dataArr.shift();
    }
    chart.data.labels.push(++counterT);
    chart.data.datasets.forEach((dataset) => {
        dataset.data.push(data);
    });
    
    chart.update();
}   

const data = {
    labels: labelArr,
    datasets: [{
      label: 'Temperature Sensor',
      data: dataArr,
      borderColor:"rgb(194, 13, 13)",
      backgroundColor:"rgba(194, 13, 13, 0.621)",
      borderWidth: 1
    }]
  };

  // config 
  const configt = {
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
  const tempChart = new Chart(
    document.getElementById('tempChart'),
    configt
  );