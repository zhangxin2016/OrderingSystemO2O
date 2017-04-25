$(document).ready(function () {
	// 输出
	$(".gwc_tb2 input[name=newslist]").click(function () {
		GetCount1();
	});
});
//******************
function GetCount1() {
	$(".gwc_tb2 input[name=newslist]").each(function () {
		if ($(this).attr("checked")) {
		}
	});
	$("#jz1").css("display", "none");
	$("#jz2").css("display", "block");
}
