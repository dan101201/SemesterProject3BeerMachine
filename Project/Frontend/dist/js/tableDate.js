function getDate(){
    const date = new Date();
    let day = date.getDate();
    var month = date.getMonth();
    let year = date.getFullYear();
    month++
    return day + "-" + month + "-"+year
}