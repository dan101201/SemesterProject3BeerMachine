function addToWarningTable(warning, timestamp, mNumber){
var table = document.getElementById("warningTable");
id = table.rows.length-1;
var row = table.insertRow(1);

var idCell = row.insertCell(0);
var warningCell = row.insertCell(1);
var timestampCell = row.insertCell(2);
var mNumberCell = row.insertCell(3);

idCell.innerHTML = id;
warningCell.innerHTML = warning;
timestampCell.innerHTML = timestamp;
mNumberCell.innerHTML = mNumber;

}