var currentForm, currentField,
    daily = 5,
    monthly = 100,
    yearly = 500;

/* event listener for enter key */
window.addEventListener('keypress', function(e) {
    if (e.keyCode == 13) {
        onBlur();
    }
}, false);


/* onclick of add employee
    shows name input */
function registerationForm() {

    document.body.style.backgroundColor = "#7FDBFF";
    employeeName = document.getElementById("empName");
    document.getElementById("addEmp").style.display = "none";
    document.getElementById("u_Registration").style.display = "block";

    document.getElementById("label").style.display = "block";
    employeeName.style.display = "block";

    currentField = "name";
    currentForm = 1;
    var image = document.getElementById("coverImg");
    image.style.display = "none";

}

/*  shows first input of vehcle form */
function vehicleForm() {

    var employeeContact = document.getElementById("ecnumber").value;
    if (!(/^[0-9]{10}$/.test(employeeContact))) {
        document.getElementById("error").innerHTML = "Please Enter Valid Contact Number";
        return false;
    } else {
        document.getElementById("error").innerHTML = " ";
    }

    document.getElementById("empContact").style.display = "none";
    document.getElementById("next1").style.display = "none";

    currentField = "vehName";
    currentForm = 2;

    document.body.style.backgroundColor = "#ffae68";
    vehicleName = document.getElementById("vehName");

    document.getElementById("u_Registration").style.display = "none";
    document.getElementById("v_Registration").style.display = "block";

    label.innerHTML = "May I know the Name of your Vehicle";
    vehicleName.style.display = "block";

    currentField = "vehName";
}


/* opens up the plan and pricing form */
function planForm() {

    document.getElementById("v_Registration").style.display = "none";
    document.getElementById("p_Registration").style.display = "block";

    document.body.style.backgroundColor = "#DDDDDD";
    document.getElementById("vehDescription").style.display = "none";
    document.getElementById("next2").style.display = "none";

    label.innerHTML = "Choose Currency for your Plan";
    document.getElementById("currType").style.display = "block";

    currentField = "currency";
    currentForm = 3;
}

/* validating password against weak , moderate and strong */
function validatePassword() {

    var employeePassword = document.getElementById("epass").value;
    document.getElementById("epass").style.borderWidth = "thick";
    if (employeePassword.length < 8) {
        document.getElementById("epass").style.borderColor = "red";
        document.getElementById("error").innerHTML = "Password Should be of minimum 8 characters";
        return false;
    } else if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(employeePassword))) {
        document.getElementById("epass").style.borderColor = "orange";
        document.getElementById("error").innerHTML = "Password should contain Uppercase, Lowercase and Numeric";
        return false;
    } else {
        document.getElementById("epass").style.borderColor = "green";
        document.getElementById("error").innerHTML = " ";
        return true;
    }
}



/* switch case for employee  form for switching input fields */
function onBlur() {

    if (currentForm == 2) {
        onBlurForm2();
        return false;
    } else if (currentForm == 3) {
        onBlurForm3();
        return false;
    }

    var label = document.getElementById("labelText");

    switch (currentField) {

        case "name":
            var employeeName = document.getElementById("ename").value;

            if (!(/^[A-z ]{2,}$/.test(employeeName))) {
                document.getElementById("error").innerHTML = "Please Enter Valid Name";
                return false;
            } else {
                document.getElementById("error").innerHTML = " ";
            }

            label.innerHTML = "Hi " + employeeName + " May I know your Gender?";

            document.getElementById("empName").style.display = "none";
            document.getElementById("empGender").style.display = "block";
            currentField = "gender";

            break;

        case "gender":

            var employeeGender = document.getElementsByName("egender");

            if (!employeeGender[0].checked && !employeeGender[1].checked) {
                document.getElementById("error").innerHTML = "Please Select Gender";
                return false;
            } else {
                document.getElementById("error").innerHTML = " ";
            }

            label.innerHTML = " You must be having a email Id";

            document.getElementById("empGender").style.display = "none";
            document.getElementById("empEmail").style.display = "block";
            currentField = "email";
            break;

        case "email":
            var employeeEmail = document.getElementById("eemail").value;

            if (!(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(employeeEmail))) {
                document.getElementById("error").innerHTML = "Please Enter Valid Email Address";
                return false;
            } else {
                document.getElementById("error").innerHTML = " ";
            }
            label.innerHTML = "Please choose a password";
            document.getElementById("empEmail").style.display = "none";
            document.getElementById("empPass").style.display = "block";
            document.getElementById("empCnfrmPass").style.display = "block";
            currentField = "password";

            break;

        case "password":
            var employeePassword = document.getElementById("epass").value;

            if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(employeePassword))) {
                document.getElementById("error").innerHTML = "Password should contain Uppercase, Lowercase,Special character,Numeric and minimum 8 characters";
                return false;
            } else {
                document.getElementById("error").innerHTML = " ";
            }

            employeePassword = document.getElementById("epass").value;
            var employeeMatchPassword = document.getElementById("ecnfrmpass").value;

            if (employeePassword != employeeMatchPassword) {
                document.getElementById("error").innerHTML = "Password Doesn't Match";
                return false;
            } else {
                document.getElementById("error").innerHTML = " ";
            }
            label.innerHTML = "Please Enter your Contact Number  ...";
            document.getElementById("empPass").style.display = "none";
            document.getElementById("empCnfrmPass").style.display = "none";
            document.getElementById("empContact").style.display = "block";
            document.getElementById("next1").style.display = "block";
            currentField = "contact";
    }


}


/* switch case for vehicle  form for switching input fields */
function onBlurForm2() {

    var vehicleName = document.getElementById("vname").value;;
    switch (currentField) {

        case "vehName":
            if (vehicleName == "") {
                document.getElementById("error").innerHTML = "This field is Required";
                return;
            }
            document.getElementById("error").innerHTML = " ";
            document.getElementById("vehName").style.display = "none";
            label.innerHTML = " whats the type of " + vehicleName;
            document.getElementById("vehType").style.display = "block";
            currentField = "vehType";

            break;

        case "vehType":
            debugger;
            var vehicleType = document.getElementById("vtype").value;

            if (vehicleType == "") {
                document.getElementById("error").innerHTML = "This field is Required";
                return;
            }
            document.getElementById("error").innerHTML = "";

            document.getElementById("vehType").style.display = "none";
            label.innerHTML = "Mention the number of " + vehicleName;
            document.getElementById("vehNumber").style.display = "block";
            currentField = "vehNumber";

            break;

        case "vehNumber":
            var vehNumber = document.getElementById("vnumber").value;
            if (!(/^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}/.test(vehNumber))) {
                document.getElementById("error").innerHTML = "Vehicle Number should be of proper type(format: RJ27PA1234).";
                return;
            }
            if (vehNumber == "") {
                document.getElementById("error").innerHTML = "This field is Required";
                return;
            }
            document.getElementById("error").innerHTML = " ";

            document.getElementById("vehNumber").style.display = "none";
            label.innerHTML = "Tell something about " + vehicleName;
            document.getElementById("vehDescription").style.display = "block";
            document.getElementById("next2").style.display = "block";
            currentField = "vehDescription";
    }


}


/* switch case for plan and pricing  form for switching input fields */
function onBlurForm3() {

    switch (currentField) {

        case "currency":
            currency = document.getElementById("currency").value;
            var vehicleType = document.getElementById("vtype").value;
            label.innerHTML = "Choose Plan for Your " + vehicleType;

            document.getElementById("plans").style.display = "block";

            currentField = "plan";

            break;

    }

}

/* showing available plans according to vehicle selected */
function showPrice() {

    var curr = document.getElementById("currency").value;
    plan = document.getElementById("plans").value;

    plans.style.display = "block";
    var v = document.getElementsByName("vehicleType")[0].children[0].value;
    document.getElementById("submit").style.display = "block";

    if (v == "Motorcycle") {
        daily = 10;
        monthly = 200;
        yearly = 1000;
    } else if (v == "FourWheeler") {
        daily = 20;
        monthly = 500;
        yearly = 3500;
    }

    switch (curr) {
        case "INR":
            document.getElementById("daily").innerHTML = daily;
            document.getElementById("monthly").innerHTML = monthly;
            document.getElementById("yearly").innerHTML = yearly;
            break;
        case "USD":
            document.getElementById("daily").innerHTML = (daily / 71.74).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / 71.74).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / 71.74).toFixed(2);
            break;
        case "YEN":
            document.getElementById("daily").innerHTML = (daily / 0.68).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / 0.68).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / 0.68).toFixed(2);

    }
}

/* on submit of plan and pricing form */
function submitForm() {

    var moneypass = '';
    document.getElementById("p_Registration").style.display = "none";
    document.getElementsByName("passtype").forEach(function(item) { if (item.checked) { moneypass = item.value } });
    if (moneypass == 'Daily') {
        moneypass = " USD " + daily + " on " + moneypass + " basis";
    } else if (moneypass == 'Monthly') {
        moneypass = "USD " + monthly + " on " + moneypass + " basis";
    } else if (moneypass == 'Yearly') {
        moneypass = "USD " + yearly + " on " + moneypass + " basis";
    }
    label.innerHTML = "Thank you for registering " + document.getElementById("ename").value + " Kindly Pay:" + moneypass;
    document.getElementById("plans").style.display = "none";
    document.getElementById("submit").style.display = "none";
    document.getElementById("currency").style.display = "none";
}