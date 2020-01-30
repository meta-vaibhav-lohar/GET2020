function passwordValidation(pass) {

    if (pass.length < 8) {
        return false;
    }
    var numbers = /\d/g;
    var numberFlag = pass.match(numbers)

    var lowerCaseLetters = /[a-z]/g;
    var lowerCaseFlag = pass.match(lowerCaseLetters);

    var upperCaseLetters = /[A-Z]/g;
    var upperCaseLettersFlag = pass.match(upperCaseLetters);

    if (numberFlag == null || lowerCaseFlag == null || upperCaseLettersFlag == null) {
        return false;
    }
    return true;
}

function validate() {
    //Checking Password
    var pass = document.getElementById("empPass").value;
    var flag = passwordValidation(pass)
    if (!flag) {
        alert("Password should have Alphanumeric character and should have upper and lower case");
    }

    //Checking ConfirmPassword
    var cpass = document.getElementById("confirmPass").value;
    if (pass.localeCompare(cpass) != 0) {
        flag = false
        alert("Passwords doesn't match")
    }
    if (flag) {
        document.getElementById("empForm").style.display = "none";
        document.getElementById("vehForm").style.display = "";
        document.getElementById("vehForm").style.visibility = "visible";
    }

}

function putValue(list) {
    console.log(list)
    document.getElementById("dailyRate1").textContent = list[0];
    document.getElementById("monthlyRate1").textContent = list[1];
    document.getElementById("yearlyRate1").textContent = list[2];
}

function price() {

    var vehicleType = document.getElementById("vehType").value;
    rateCard = {
        "cycle": [5, 100, 500],
        "bike": [10, 200, 1000],
        "car": [20, 500, 3500]
    };
    document.getElementById("vehForm").style.display = "none";
    document.getElementById("rateCard").style.display = "";
    document.getElementById("vehForm").style.visibility = "visible";
    putValue(rateCard[vehicleType]);

}

function bill() {
    console.log("Bill");


    // document.getElementById("")
    var plan = document.getElementsByName("plan");
    var field;
    for (iterator = 0; iterator < plan.length; iterator++) {
        if (plan[iterator].checked)
            field = plan[iterator].value;
    }
    field += "Rate1"
    console.log(field);
    var price = document.getElementById(field).textContent;

    document.getElementById("vehForm").style.display = "none";

    console.log(price);
    document.getElementById("rateCard").style.display = "none";

    const url = 'https://api.exchangerate-api.com/v4/latest/INR';
    fetch(url)
        .then(res => res.json()) //response type
        .then(data => {
            document.getElementById("bill").innerHTML += "<p> USD: " + price * data["rates"]["USD"] + "</p> <p> YEN: " + price * data["rates"]["JPY"] + "</p>"

        });

}