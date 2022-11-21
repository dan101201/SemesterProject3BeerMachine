// setup 
counterH = 0
labelArr = []
dataArr = []
MAX_DATA_POINTS = 120;

function addDataH(chart, data) {
    if (labelArr.length > MAX_DATA_POINTS) {
        labelArr.shift();
        dataArr.shift();
    }
    chart.data.labels.push(++counterH);
    chart.data.datasets.forEach((dataset) => {
        dataset.data.push(data);
    });

    chart.update();
}

const dataH = {
    labels: labelArr,
    datasets: [{
        label: 'Humidity sensor',
        data: dataArr,
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