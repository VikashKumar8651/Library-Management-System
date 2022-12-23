
 $(document).ready(() => {
        $("#circulationcontrolfinalactionbuttonsissue").click(() => {
      	  document.getElementById("circulationform").disabled = true;
          $("#circulationcontrolfinalactionbuttonsissue").css(
            "background-color",
            "#aacbd1"
          );
          $.ajax({
              type: 'GET',
              url: 'bookissue',
              data: $('#circulationform').serialize(),
              success: function (response) {
              	// var op = $.parseJSON(JSON.stringify(response));
              	 //console.log(op);
  				// fillstudentattendancedetails(op);
    				alert(response);
    				 document.getElementById("circulationform").reset();
   				$("#circulationcontrolfinalactionbuttonsreturn").css(
   			            "background-color",
   			            "#98cbd5"
   			          );
              
          }});
      	  document.getElementById("circulationform").disabled = false;
        });
       
        
          
        
       /*  $("#circulationcontrolfinalactionbuttonsissue").mouseup(() => {
          $("#circulationcontrolfinalactionbuttonsissue").css(
            "background-color",
            "#98cbd5"
          );
        }); */
        $("#circulationcontrolfinalactionbuttonsreturn").mousedown(() => {
          $("#circulationcontrolfinalactionbuttonsreturn").css(
            "background-color",
            "#aacbd1"
          );
          $.ajax({
              type: 'GET',
              url: 'bookreturn',
              data: $('#circulationform').serialize(),
              success: function (response) {
              	// var op = $.parseJSON(JSON.stringify(response));
              	 //console.log(op);
  				// fillstudentattendancedetails(op);
            	  document.getElementById("circulationform").disabled = true;
    				alert(response);
    				 document.getElementById("circulationform").reset();
   				 document.getElementById("circulationform").disabled = false;
   				$("#circulationcontrolfinalactionbuttonsreturn").css(
   			            "background-color",
   			            "#98cbd5"
   			          );
              
          }});
        });
       /*  $("#circulationcontrolfinalactionbuttonsreturn").mouseup(() => {
          $("#circulationcontrolfinalactionbuttonsreturn").css(
            "background-color",
            "#98cbd5"
          );
        }); */
        $("#circulationcontrolfinalactionbuttonsrenewal").mousedown(() => {
          $("#circulationcontrolfinalactionbuttonsrenewal").css(
            "background-color",
            "#aacbd1"
          );
          $.ajax({
              type: 'GET',
              url: 'bookrenew',
              data: $('#circulationform').serialize(),
              success: function (response) {
              	// var op = $.parseJSON(JSON.stringify(response));
              	 //console.log(op);
  				// fillstudentattendancedetails(op);
            	  document.getElementById("circulationform").disabled = true;
    				alert(response);
    				 document.getElementById("circulationform").reset();
   				 document.getElementById("circulationform").disabled = false;
   				$("#circulationcontrolfinalactionbuttonsreturn").css(
   			            "background-color",
   			            "#98cbd5"
   			          );
              
          }});
        });
       /*  $("#circulationcontrolfinalactionbuttonsrenewal").mouseup(() => {
          $("#circulationcontrolfinalactionbuttonsrenewal").css(
            "background-color",
            "#98cbd5"
          );
        }); */
        $("#circulationcontrolfinalactionbuttonsclearall").mousedown(() => {
          $("#circulationcontrolfinalactionbuttonsclearall").css(
            "background-color",
            "#aacbd1"
          );
        });
        $("#circulationcontrolfinalactionbuttonsclearall").mouseup(() => {
          $("#circulationcontrolfinalactionbuttonsclearall").css(
            "background-color",
            "#98cbd5"
          );
        });
      });

