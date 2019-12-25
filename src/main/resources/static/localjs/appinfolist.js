$(".addVersion").on("click", function () {
    var obj = $(this);
    window.location.href = "appversionadd?id=" + obj.attr("appinfoid");
});
$(".viewApp").on("click", function () {
    var obj = $(this);
    window.location.href = "appview/" + obj.attr("appinfoid");
});

	
