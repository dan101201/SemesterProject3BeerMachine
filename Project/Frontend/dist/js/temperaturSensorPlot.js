// setup 
counterT = 0
MAX_DATA_POINTS = 20;

function addDataT(chart, data) {
  chart.data.datasets.forEach((dataset) => {
    if (counterT > MAX_DATA_POINTS) {
      chart.data.labels.shift();
      dataset.data.shift();
    }
    dataset.data.push(data);
  });
  chart.data.labels.push(++counterT);

  chart.update();
}

const data = {
  labels: [],
  datasets: [{
    label: 'Temperature Sensor',
    data: [],
    borderColor: "rgb(194, 13, 13)",
    backgroundColor: "rgba(194, 13, 13, 0.621)",
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