$(document).ready(filldashboard);

function filldashboard(){
	
	$.ajax({
		type: 'POST',
        url: 'dashboardinfo',
        headers:{
      	     Accept:"application/json; charset=utf-8",
      		"Content-Type":"application/json; charset=utf-8"
      		    },
        data:"hello",
        success: function (response) {
          	 var opdashboard = $.parseJSON(JSON.stringify(response));
           	 console.log(opdashboard);
           	 $("#dashboard2totalbooksnos").text(opdashboard.totalbooks);
	$("#dashboard2totalbooksbranchwisecseitno").text(opdashboard.cseit);
	$("#dashboard2totalbooksbranchwisemechno").text(opdashboard.MECHANICAL);
	$("#dashboard2totalbooksbranchwisebiotechno").text(opdashboard.BIO_TECH);
	$("#dashboard2totalbooksbranchwisebiomedno").text(opdashboard.BIO_MED);
	$("#dashboard2totalbooksbranchwiseeceno").text(opdashboard.ECE);
	$("#dashboard2totalbooksbranchwisechemicalno").text(opdashboard.CHEMICAL);
	$("#dashboard2totalbooksbranchwisecivilno").text(opdashboard.CIVIL);
	$("#dashboard2totalbooksbranchwisefoodtechno").text(opdashboard.FOOD_TECH);
	$("#dashboard2totalbooksbranchwisePHARMACYno").text(opdashboard.PHARMACY);
	$("#dashboard2totalbooksbranchwiselawsno").text(opdashboard.LLB);
	$("#dashboard2totalbooksbranchwisebbano").text(opdashboard.BBA);
	$("#dashboard2totalbooksbranchwiseagrino").text(opdashboard.AGRICULTURE);
    $("#dashboard2totalstudentaccountinlibrarymsgno").text(opdashboard.totalaccount);
    $("#dashboard2totalstudentaccountinlibrarynomsgno").text(opdashboard.visitorinside);
   const dd=new Date();
   dd.setDate(dd.getDate()+14);
    $("#dashboard2duedate").text(moment().add(14,'days').calendar());

          }});
	
}

$("#dashboard2refreshbutton").click(filldashboard);
