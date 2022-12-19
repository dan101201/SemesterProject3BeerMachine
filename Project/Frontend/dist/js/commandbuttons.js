function commandStart() {
    resetCurrentBatchTable()
    fetch("http://localhost:4567/machine/0/command/start/");
}

function commandStop() {
    fetch("http://localhost:4567/machine/0/command/stop/");
}

function commandAbort() {
    fetch("http://localhost:4567/machine/0/command/abort/");
}

function commandClear() {
    fetch("http://localhost:4567/machine/0/command/clear/");
}

function commandReset() {
    fetch("http://localhost:4567/machine/0/command/reset/");
}