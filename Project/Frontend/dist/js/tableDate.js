function getDate(){
    const date = new Date();
    let day = date.getDate();
    var month = date.getMonth();
    let year = date.getFullYear();
    let hours = date.getHours();
    let minutes = date.getMinutes();
    let seconds =  date.getSeconds();
    month++
    return day + "-" + month + "-"+year + " " + hours+":"+minutes+";"+seconds
}