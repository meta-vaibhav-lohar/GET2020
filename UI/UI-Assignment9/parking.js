var currentField;
var currentForm;
var daily = 5, monthly = 100, yearly = 500;
/* Class representing employee */
var Employee = /** @class */ (function () {
    function Employee() {
    }
    Employee.prototype.registerationForm = function () {
        document.body.style.backgroundColor = "#7FDBFF";
        document.getElementById("addEmp").style.display = "none";
        document.getElementById("u_Registration").style.display = "block";
        document.getElementById("label").style.display = "block";
        document.getElementById("empName").style.display = "block";
        currentField = "name";
        currentForm = 1;
        document.getElementById("coverImg").style.display = "none";
    };
    Employee.prototype.employeeBlur = function () {
        if (currentForm == 2) {
            veh.vehicleBlur();
            return false;
        }
        var label = document.getElementById("labelText");
        switch (currentField) {
            case "name":
                var name_1 = document.getElementById("ename").value;
                if (!(/^[A-z ]{2,}$/.test(name_1))) {
                    document.getElementById("error").innerHTML = "Please Enter Valid Name";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "Hi " + name_1 + " May I know your Gender?";
                document.getElementById("empName").style.display = "none";
                document.getElementById("empGender").style.display = "block";
                currentField = "gender";
                break;
            case "gender":
                // let gender: NodeList = document.getElementsByName("egender") as NodeList;
                var gender = document.getElementsByName("egender");
                if (!gender[0].checked && !gender[1].checked) {
                    document.getElementById("error").innerHTML = "Please Select Gender";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = " You must be having a email Id";
                document.getElementById("empGender").style.display = "none";
                document.getElementById("empEmail").style.display = "block";
                currentField = "email";
                break;
            case "email":
                var email = document.getElementById("eemail").value;
                if (!(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(email))) {
                    document.getElementById("error").innerHTML = "Please Enter Valid Email Address";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "Please choose a password";
                document.getElementById("empEmail").style.display = "none";
                document.getElementById("empPass").style.display = "block";
                document.getElementById("empCnfrmPass").style.display = "block";
                currentField = "password";
                break;
            case "password":
                var password = document.getElementById("epass").value;
                if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(password))) {
                    document.getElementById("error").innerHTML = "Password should contain Uppercase, Lowercase,Special character,Numeric and minimum 8 characters";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                var employeeMatchPassword = document.getElementById("ecnfrmpass").value;
                if (password != employeeMatchPassword) {
                    document.getElementById("error").innerHTML = "Password Doesn't Match";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "Please Enter your Contact Number  ...";
                document.getElementById("empPass").style.display = "none";
                document.getElementById("empCnfrmPass").style.display = "none";
                document.getElementById("empContact").style.display = "block";
                document.getElementById("next1").style.display = "block";
                currentField = "contact";
        }
        return true;
    };
    return Employee;
}());
function validatePassword() {
    var employeePassword = document.getElementById("epass").value;
    document.getElementById("epass").style.borderWidth = "thick";
    if (employeePassword.length < 8) {
        document.getElementById("epass").style.borderColor = "red";
        document.getElementById("error").innerHTML = "Password Should be of minimum 8 characters";
        return false;
    }
    else if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(employeePassword))) {
        document.getElementById("epass").style.borderColor = "orange";
        document.getElementById("error").innerHTML = "Password should contain Uppercase, Lowercase and Numeric";
        return false;
    }
    else {
        document.getElementById("epass").style.borderColor = "green";
        document.getElementById("error").innerHTML = " ";
        return true;
    }
}
/* class representing a vehicle */
var Vehicle = /** @class */ (function () {
    function Vehicle() {
    }
    ;
    /*  shows first input of vehicle form */
    Vehicle.prototype.vehicleForm = function () {
        var employeeContact = document.getElementById("ecnumber").value;
        if (!(/^[0-9]{10}$/.test(employeeContact))) {
            document.getElementById("error").innerHTML = "Please Enter Valid Contact Number";
            return false;
        }
        else {
            document.getElementById("error").innerHTML = " ";
        }
        document.getElementById("empContact").style.display = "none";
        document.getElementById("next1").style.display = "none";
        currentField = "vehName";
        currentForm = 2;
        document.body.style.backgroundColor = "#ffae68";
        document.getElementById("u_Registration").style.display = "none";
        document.getElementById("v_Registration").style.display = "block";
        document.getElementById('labelText').innerHTML = "May I know the Name of your Vehicle";
        document.getElementById("vehName").style.display = "block";
        document.getElementById("vname").focus();
        currentField = "vehName";
        return true;
    };
    /* switch case for vehicle  form for switching input fields */
    Vehicle.prototype.vehicleBlur = function () {
        var vehicleName = document.getElementById("vname").value;
        ;
        switch (currentField) {
            case "vehName":
                if (vehicleName == "") {
                    document.getElementById("error").innerHTML = "This field is Required";
                    return false;
                }
                document.getElementById("error").innerHTML = " ";
                document.getElementById("vehName").style.display = "none";
                document.getElementById('labelText').innerHTML = " Whats the type of " + vehicleName;
                document.getElementById("vehType").style.display = "block";
                currentField = "vehType";
                break;
            case "vehType":
                var vehicleType = document.getElementById("vtype").value;
                if (vehicleType == "") {
                    document.getElementById("error").innerHTML = "This field is Required";
                    return false;
                }
                document.getElementById("error").innerHTML = "";
                document.getElementById("vehType").style.display = "none";
                document.getElementById('labelText').innerHTML = "Can you please Mention the number of " + vehicleName;
                document.getElementById("vehNumber").style.display = "block";
                currentField = "vehNumber";
                break;
            case "vehNumber":
                var vehNumber = document.getElementById("vnumber").value;
                if (!(/^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}/.test(vehNumber))) {
                    document.getElementById("error").innerHTML = "Vehicle Number should be of proper type.";
                    return false;
                }
                if (vehNumber == "") {
                    document.getElementById("error").innerHTML = "This field is Required";
                    return false;
                }
                document.getElementById("error").innerHTML = " ";
                document.getElementById("vehNumber").style.display = "none";
                document.getElementById('labelText').innerHTML = "Tell something about " + vehicleName;
                document.getElementById("vehDescription").style.display = "block";
                document.getElementById("next2").style.display = "block";
                currentField = "vehDescription";
        }
        return true;
    };
    return Vehicle;
}());
/* class for Plans and pricing */
var Plan = /** @class */ (function () {
    function Plan() {
    }
    ;
    /* opens up the plan and pricing form */
    Plan.prototype.planForm = function () {
        document.getElementById("v_Registration").style.display = "none";
        document.getElementById("p_Registration").style.display = "block";
        document.body.style.backgroundColor = "#DDDDDD";
        document.getElementById("vehDescription").style.display = "none";
        document.getElementById("next2").style.display = "none";
        document.getElementById('labelText').innerHTML = "Choose Currency for your Plan";
        document.getElementById("currType").style.display = "block";
        currentField = "currency";
        currentForm = 3;
    };
    /* on submit of plan and pricing form */
    Plan.prototype.submitForm = function () {
        var moneypass = '';
        document.getElementById("p_Registration").style.display = "none";
        document.getElementsByName("passtype").forEach(function (item) {
            if (item.checked) {
                moneypass = item.value;
            }
        });
        if (moneypass == 'Daily') {
            moneypass = " USD " + (daily / 71.74).toFixed(2) + " on " + moneypass + " basis";
        }
        else if (moneypass == 'Monthly') {
            moneypass = "USD " + (monthly / 71.74).toFixed(2) + " on " + moneypass + " basis";
        }
        else if (moneypass == 'Yearly') {
            moneypass = "USD " + (yearly / 71.74).toFixed(2) + " on " + moneypass + " basis";
        }
        document.getElementById('labelText').innerHTML = "Thank you for registering " + document.getElementById("ename").value + " Kindly Pay:" + moneypass;
        document.getElementById("plans").style.display = "none";
        document.getElementById("submit").style.display = "none";
        document.getElementById("currency").style.display = "none";
    };
    /* showing available plans according to vehicle selected */
    Plan.prototype.showPrice = function () {
        var curr = document.getElementById("currency").value;
        var plan = document.getElementById("plans");
        plan.style.display = "block";
        var v = document.getElementsByName("vehicleType")[0].children[0].value;
        document.getElementById("submit").style.display = "block";
        if (v == "Motorcycle") {
            daily = 10;
            monthly = 200;
            yearly = 1000;
        }
        else if (v == "FourWheeler") {
            daily = 20;
            monthly = 500;
            yearly = 3500;
        }
        switch (curr) {
            case "INR":
                document.getElementById("daily").innerHTML = "" + daily;
                document.getElementById("monthly").innerHTML = "" + monthly;
                document.getElementById("yearly").innerHTML = "" + yearly;
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
    };
    return Plan;
}());
var emp = new Employee();
var veh = new Vehicle();
var plan = new Plan();
/* event listener for enter key */
window.addEventListener('keypress', function (e) {
    if (e.keyCode == 13) {
        emp.employeeBlur();
    }
}, false);
/* redirects to emp registration form */
function registerationFormCaller() {
    emp.registerationForm();
}
/* redirects to vehicle form */
function vehicleFormCaller() {
    veh.vehicleForm();
}
/* redirects to plan form */
function planFormCaller() {
    plan.planForm();
}
/* redirects to submit form method*/
function submitFormCaller() {
    plan.submitForm();
}
/* redirects to show price method */
function showPriceCaller() {
    plan.showPrice();
}
