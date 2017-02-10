function startTime() {
	var options = {
		    weekday: "long",
		    year: "numeric",
		    month: "long",
		    day: "numeric"
		};
	var locale = "es-ES";
    var today=new Date();
    var h=today.getHours();
    var m=today.getMinutes();
    var s=today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML = "Hoy es " +today.toLocaleDateString(locale, options) +" y son las "+ h+":"+m+":"+s;
    var t = setTimeout(function(){startTime()},500);
}

function checkTime(i) {
    if (i<10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}
