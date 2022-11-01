/**
 * 
 */
 
 
 function validate(frm){
	
	// Empty the error messages
	document.getElementsById("pnameErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	
	// read form data
	let name = frm.pname.value;
	let age= frm.page.value;
	
	alert("1");
	
	//write client side form validation logic
	let vflag = true;
	if(name==""){ // required rule 
		vflag = false;
		document.getElementById("pnameErr").innerHTML="<b>Person name is required</b>";
	}
	
	else if(name.length <5 || name.length >10 ){
		vflag = false;
		document.getElementById("pnameErr").innerHTML="<b>Person name should have min of 5 chars and max of 10 characters</b>";
	}
	
	alert("2");
	
	
	if(age == ""){
		vflag = false;
		document.getElementById("pageErr").innerHTML="<b> Person age is required </b>";
	}
	else if(isNaN(age)){
		vflag=false;
		document.getElementById("pageErr").innerHTML="<b>Person age should be given in the form of numeric value</b>";
	}
	else if(age<0 || age>100){
		vflag=false;
		document.getElementById("pageErr").innerHTML="<b>Person age should be there in the range of 1 through 100</b>";
	}
	
	alert("3");
	// change the hidden box value to "yes" indicating verification in javascript is enabled
	frm.vstatus.value ="yes";
	
	return vflag;
}