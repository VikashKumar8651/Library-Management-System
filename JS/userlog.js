    var cookie=document.cookie.split(';').map(cookie => cookie.split('=')).reduce((accumulator, [key, value]) => ({ ...accumulator, [key.trim()]: decodeURIComponent(value) }), {});
     
    sessionStorage.setItem("cuser",cookie.user);
    if (sessionStorage.getItem("cuser") == 'undefined') {
   	 /*  alert("hello"); */
   	   location.replace("login.html");
   } else {
       console.log("hi from home");
   	/*   alert("welcome home"); */
   }
