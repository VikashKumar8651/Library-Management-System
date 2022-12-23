document.getElementById("subscriptionmagazineaddnewformrightdateinputfromdate").addEventListener('change',()=>{
    document.getElementById("subscriptionmagazineaddnewformrightdateinputfromdateplacefordatevalue").value=document.getElementById("subscriptionmagazineaddnewformrightdateinputfromdate").value;
})
document.getElementById("subscriptionmagazineaddnewformrightdateinputTodate").addEventListener('change',()=>{
    document.getElementById("subscriptionmagazineaddnewformrightdateinputTodateplacefordatevalue").value=document.getElementById("subscriptionmagazineaddnewformrightdateinputTodate").value;
})
document.getElementById("subscriptionmagazineaddnewformrightdateinputDDdate").addEventListener('change',()=>{
    document.getElementById("subscriptionmagazineaddnewformrightdateinputDDdateplacefordatevalue").value=document.getElementById("subscriptionmagazineaddnewformrightdateinputDDdate").value;
})


document.getElementById("subscriptionmagazinefinalbuttonsaddnew").addEventListener('click',()=>{
    document.getElementById("subscriptionmagazineaddnew").style.display="flex";
    document.getElementById("subscriptionmagazinetablebap").style.display="none";
})

document.getElementById("subscriptionmagazineaddnewnavigationbutton").addEventListener('click',()=>{
    document.getElementById("subscriptionmagazinetablebap").style.display="flex";
    document.getElementById("subscriptionmagazineaddnew").style.display="none";
})

document.getElementById("subscriptionmagazineeditmagazinenavigationbutton").addEventListener('click',()=>{
    document.getElementById("subscriptionmagazineeditmagazinebap").style.display="none";
    document.getElementById("subscriptionmagazinetablebap").style.display="flex";
})




document.getElementById("subscriptionmagazinefinalbuttonseditexisting").addEventListener('click',()=>{
    document.getElementById("subscriptionmagazinetablebap").style.display="none";
    document.getElementById("subscriptionmagazineaddnew").style.display="none";
    document.getElementById("subscriptionmagazineeditmagazinebap").style.display="flex";
})


function fillsubstablerenew(op){
	let l=op.Title.length;
		console.log(op);
		console.log(op);
	alert("fillsubstablerenew");
	for(let i=0;i<l;i++){
            $("#subscriptionmagazinerenewsubbaptable").append("<tr onclick="+"h('"+op.Title[i]+"','"+op.Place[i]+"','"+op.Publisher[i]+"','"+op.Department[i]+"','"+op.Type[i]+"','"+op.ddno[i]+"')"+"><td>"+op.Title[i]+"</td><td>"+op.Publisher[i]+"</td><td>"+op.Department[i]+"</td><td>"+op.Type[i]+"</td><td>"+op.Periodicity[i]+"</td><td>"+op.Place[i]+"</td><td>"+op.FROM_Date[i]+"</td><td>"+op.To_Date[i]+"</td><td>"+op.ddno[i]+"</td></tr>");
	}
	console.log(op);
		alert("fillsubstablerenew2");
}

/*title,place,publisher,department,type*/


document.getElementById("subscriptionmagazinefinalbuttonsrenewexisting").addEventListener('click',()=>{
    document.getElementById("subscriptionmagazinetablebap").style.display="none";
    document.getElementById("subscriptionmagazinerenewsubbap").style.display="flex";
    document.getElementById("subscriptionmagazinerenewsubsformbap").style.display="none";
    document.getElementById("subscriptionmagazinerenewsubbaptablebap").style.display="flex";
    document.getElementById("subscriptionmagazinerenewsubbapnavigationback").style.display="flex";


   $.ajax({
		type: 'GET',
        url: 'subscriptionmagazinedata',
        success: function (response){
	       var op = $.parseJSON(JSON.stringify(response));
	       console.log(op);
	       fillsubstablerenew(op);
        }
	});

});
  
document.getElementById("subscriptionmagazinerenewsubbapnavigationbackbutton").addEventListener('click',()=>{
    document.getElementById("subscriptionmagazinetablebap").style.display="flex";
    document.getElementById("subscriptionmagazinerenewsubbap").style.display="none";
});
/*
document.getElementById("subscriptionmagazinerenewsubsformfinalbuttonrenewsubs").addEventListener('click',()=>{
     alert("clicked");
});*/


document.getElementById("subscriptionmagazinerenewsubsformbapnavigationbackbutton").addEventListener('click',()=>{
    document.getElementById("subscriptionmagazinerenewsubbaptablebap").style.display="flex";
    document.getElementById("subscriptionmagazinerenewsubbapnavigationback").style.display="flex";
    document.getElementById("subscriptionmagazinerenewsubsformbap").style.display="none";
});


   
function fillsubstable(op){
	let length=op.Title.length;
	for(let i=0;i<length;i++){
            $("#subscriptionmagazinetablebaptable").append("<tr><td>"+op.Title[i]+"</td><td>"+op.Publisher[i]+"</td><td>"+op.Department[i]+"</td><td>"+op.Type[i]+"</td><td>"+op.Periodicity[i]+"</td><td>"+op.Place[i]+"</td><td>"+op.FROM_Date[i]+"</td><td>"+op.To_Date[i]+"</td></tr>");
	}
}
   $.ajax({
		type: 'GET',
        url: 'subscriptionmagazinedata',
        success: function (response){
	       var op = $.parseJSON(JSON.stringify(response));
	       console.log(op);
	       fillsubstable(op);
        }
});


 function h(title,place,publisher,department,type,ddno){
    	document.getElementById("subscriptionmagazinerenewsubsformbap").style.display="flex";
    	document.getElementById("subscriptionmagazinerenewsubbaptablebap").style.display="none";
    	document.getElementById("subscriptionmagazinerenewsubbapnavigationback").style.display="none";
    	document.getElementById("subscriptionmagazinerenewformlefttitle").value=title;
     	document.getElementById("subscriptionmagazinerenewformrighttextinputplace").value=place;
    	document.getElementById("subscriptionmagazinerenewformleftpublisher").value=publisher;
    	document.getElementById("subscriptionmagazinerenewformleftselect").value=department;
    	document.getElementById("subscriptionmagazinerenewformleftselect").value=type;
    	document.getElementById("subscriptionmagazinerenewformleftddno").value=ddno;

    //	document.getElementById("subscriptionmagazineaddnewformleftselect").value=period;
  	
   //     alert(title+place+publisher+department+type);
}

$("#subscriptionmagazinerenewsubsformfinalbuttonrenewsubs").click(()=>{
	$.ajax({
		type: 'GET',
        url: 'subscriptionmagazinerenewexisting',
        data: $("#subscriptionmagazinerenewsubsform").serialize(),
        success: function (response){
	       console.log(response);
	       alert(response);
	}});
});



document.getElementById("subscriptionmagazinerenewformrightdateinputfromdate").addEventListener('change',()=>{
	document.getElementById("subscriptionmagazinerenewformrightdateinputfromdateplacefordatevalue").value=document.getElementById("subscriptionmagazinerenewformrightdateinputfromdate").value;
})


document.getElementById("subscriptionmagazinerenewformrightdateinputTodate").addEventListener('change',()=>{
	document.getElementById("subscriptionmagazinerenewformrightdateinputTodateplacefordatevalue").value=document.getElementById("subscriptionmagazinerenewformrightdateinputTodate").value;
})


document.getElementById("subscriptionmagazinerenewformrightdateinputDDdate").addEventListener('change',()=>{
	document.getElementById("subscriptionmagazinerenewformrightdateinputDDdateplacefordatevalue").value=document.getElementById("subscriptionmagazinerenewformrightdateinputDDdate").value;
})


document.getElementById("subscriptionmagazineaddnewformfinalbuttonaddmagazine").addEventListener('click',()=>{
	$.ajax({
		type: 'GET',
        url: 'addnewsubscriptions',
        data: $("#subscriptionmagazineaddnewform").serialize(),
        success: function (response){
	       console.log(response);
	       alert(response);
	}});
})


document.getElementById("subscriptionmagazineeditmagazineformfinalbuttonaddmagazine").addEventListener('click',()=>{
	$.ajax({
		type: 'GET',
        url: 'subscriptionmagazineedit',
        data: $("#subscriptionmagazineeditform").serialize(),
        success: function (response){
	       console.log(response);
	       alert(response);
	       document.getElementById("subscriptionmagazineeditform").reset();
	}});
})

document.getElementById("subscriptionmagazineeditformrightdateinputfromdate").addEventListener('change',()=>{
	document.getElementById("subscriptionmagazineeditformrightdateinputfromdateplacefordatevalue").value=document.getElementById("subscriptionmagazineeditformrightdateinputfromdate").value;
})

document.getElementById("subscriptionmagazineeditformrightdateinputTodate").addEventListener('change',()=>{
	document.getElementById("subscriptionmagazineeditformrightdateinputTodateplacefordatevalue").value=document.getElementById("subscriptionmagazineeditformrightdateinputTodate").value;
})

document.getElementById("subscriptionmagazineeditformrightdateinputDDdate").addEventListener('change',()=>{
	document.getElementById("subscriptionmagazineeditformrightdateinputDDdateplacefordatevalue").value=document.getElementById("subscriptionmagazineeditformrightdateinputDDdate").value;
})



    	