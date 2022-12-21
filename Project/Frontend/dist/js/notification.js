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
var idCell;
var recipeCell;
var speedCell
var processedCell;
var acceptedCell;
var declinedCell;
var machineCell;
var timestampCell;
var currentId = 0;
var startTimestamp;
var oeeCell;

function getOee(accepted, idealCycle, plannedTime) {
    return accepted*idealCycle/plannedTime;
}

function resetCurrentBatchTable(){
    document.getElementById("currentTable").deleteRow(1);
    currentId = 0;
    
}

function updateCurrentBatchTable(processed, accepted, declined) {
    var table = document.getElementById("currentTable");
    currentId++;
    if(getSpeed() != 0) {
        if (table.rows.length < 2) {
            row = table.insertRow(1);
            idCell = row.insertCell(0);
            recipeCell = row.insertCell(1);
            speedCell = row.insertCell(2)
            processedCell = row.insertCell(3);
            acceptedCell = row.insertCell(4);
            declinedCell = row.insertCell(5);
            machineCell = row.insertCell(6);
            timestampCell = row.insertCell(7);
            startTimestamp = row.insertCell(8);
            startTimestamp.innerHTML = getDate();
            recipeCell.innerHTML = getRecipe();
            speedCell.innerHTML = getSpeed();
        }
    
        idCell.innerHTML = currentId;
        processedCell.innerHTML = processed;
        acceptedCell.innerHTML = accepted;
        declinedCell.innerHTML = declined;
        machineCell.innerHTML = "0";
        timestampCell.innerHTML = getDate();
    }
}

function updateLastBatchTable() {
    var table = document.getElementById("oldTable");
        row = table.insertRow(currentId+1);
        idCell = row.insertCell(0);
        recipeCell = row.insertCell(1);
        speedCell = row.insertCell(2)
        processedCell = row.insertCell(3);
        acceptedCell = row.insertCell(4);
        declinedCell = row.insertCell(5);
        machineCell = row.insertCell(6);
        timestampCell = row.insertCell(7);
        startTimestamp = row.insertCell(8);
        oeeCell = row.insertCell(8);
        oeeCell.innerHTML = getOee(acceptedCell, idealCycle, plannedTime);

}