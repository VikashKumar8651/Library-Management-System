function placefordailyreportkabapfromdatefun() {
    let a = document.getElementById("dailyreportkabapfromdate").value;
    document.getElementById("placefordailyreportkabapfromdate").value = a;
  }
  function placefordailyreportkabaptodatefun() {
    let a = document.getElementById("dailyreportkabaptodate").value;
    document.getElementById("placefordailyreportkabaptodate").value = a;
  }
  
  /*
  document.getElementById("#dailyreportkabapformfinalbuttonsgeneratereport").addEventListener('click',function(e){
	e.preventDefault();
$.ajax({
	 type: 'GET',
     url: 'dailyreports',
    /* headers:{
			 Accept:"application/vnd.ms-excel; charset=utf-8",
			 "Content-Type":"application/vnd.ms-excel; charset=utf-8"
  			 },*//*
     data: $('#dailyreportkabapform').serialize(),
     success: function (response) {
	      console.log(response);
   		  window.open('data:application/vnd.ms-excel,' + encodeURIComponent(response)); 
      }});
});
*/