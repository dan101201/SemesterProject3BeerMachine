function addToWarningTable(warning, timestamp, mNumber) {
    var table = document.getElementById("warningTable");
    id = table.rows.length - 1;
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
var row;
var cTable
var cell
var currentId = 0;
var oeeCell;


function getOee(accepted, idealCycle, plannedTime) {
    return accepted * idealCycle / plannedTime;
}

function resetCurrentBatchTable() {
    document.getElementById("currentTable").deleteRow(1);
}

function updateCurrentBatchTable(processing, accepted, declined, produced) {
    var table = document.getElementById("currentTable");

    if(processing == produced){
        updateLastBatchTable();
    }
    if (getSpeed() != 0) {
        if (table.rows.length < 2) {
            row = table.insertRow(1);

            for (var c = 0; c < 9; c++) {
                cell = row.insertCell(c);
            }

            table.rows[1].cells[7].innerHTML = getDate()
            table.rows[1].cells[1].innerHTML = getRecipe()
            table.rows[1].cells[2].innerHTML = getSpeed()
            currentId++;
        }

        table.rows[1].cells[0].innerHTML = currentId;
        table.rows[1].cells[3].innerHTML = processing;
        table.rows[1].cells[4].innerHTML = accepted;
        table.rows[1].cells[5].innerHTML = declined;
        table.rows[1].cells[6].innerHTML = "0";
        table.rows[1].cells[8].innerHTML = getDate();
    }
    cTable = table
}
var pTable
function updateLastBatchTable() {
    var table = document.getElementById("oldTable");
    pTable = cTable
    row = table.insertRow(1);
    for (var c = 0; c < pTable.rows[1].cells.length - 1; c++) {
        cell = row.insertCell(c);
        cell.innerHTML = pTable.rows[1].cells[c].innerHTML
    }
    cell = row.insertCell(c);
    cell.innerHTML = getDate();
    resetCurrentBatchTable()
}