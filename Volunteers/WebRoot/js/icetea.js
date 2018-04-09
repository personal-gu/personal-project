
$(document).ready(function time() {
    setInterval(function () {
        $('#public_date').val(new Date().toLocaleString());
    },1000);
});