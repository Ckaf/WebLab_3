function zero_first_format(value) {
    if (value < 10) {
        value = '0' + value;
    }
    return value;
}

function date_time() {
    const current_datetime = new Date();
    const day = zero_first_format(current_datetime.getDate());
    const month = zero_first_format(current_datetime.getMonth() + 1);
    const year = current_datetime.getFullYear();
    const hours = zero_first_format(current_datetime.getHours());
    const minutes = zero_first_format(current_datetime.getMinutes());
    const seconds = zero_first_format(current_datetime.getSeconds());

    return day + "." + month + "." + year + " " + hours + ":" + minutes + ":" + seconds;

}

setTimeout(function () {
    document.getElementById('current_date_time').innerHTML = date_time();
}, 0)

setInterval(function () {
    document.getElementById('current_date_time').innerHTML = date_time();
}, 13000);