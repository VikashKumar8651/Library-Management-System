
    document.getElementById("dashboardlogoutbapbtn").addEventListener("click",function(){
   	// sessionStorage.clear();  
   	document.cookie="user="+sessionStorage.getItem("cuser")+";max-age=0";  
       sessionStorage.removeItem("cuser");
   	alert("logging out...");
   	   location.replace("login.html");
    });
    
    