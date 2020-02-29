function getPass(){

	document.getElementById("vehicleDiv").style.display="none";
    getPrice();
    
}	

function getPrice(){
	
	 const url = 'http://localhost:8080/api/prices'
	    fetch(url)
	        .then(res => res.json()) // response type
	        .then(list => {
	        	
	        	console.log(list);
	        	var key = document.getElementById("list").value;
	        	console.log(list[key][0])
	            document.getElementById("dailyRate1").textContent = "Rs. "+ list[key][0];
	            document.getElementById("monthlyRate1").textContent ="Rs. "+  list[key][1];
	            document.getElementById("yearlyRate1").textContent ="Rs. "+  list[key][2];
	            document.getElementById("passDiv").style.display = "";
	            document.getElementById("passDiv").style.visibility = "visible";
	        });
}
