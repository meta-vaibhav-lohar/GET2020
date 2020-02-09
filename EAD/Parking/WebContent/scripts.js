const FloatLabel = (() => {

    // add active class and placeholder 
    const handleFocus = (e) => {
        const target = e.target;
        target.parentNode.classList.add('active');
        target.setAttribute('placeholder', target.getAttribute('data-placeholder'));
    };

    // remove active class and placeholder
    const handleBlur = (e) => {
        const target = e.target;
        if (!target.value) {
            target.parentNode.classList.remove('active');
        }
        target.removeAttribute('placeholder');
    };

    // register events
    const bindEvents = (element) => {
        const floatField = element.querySelector('input');
        floatField.addEventListener('focus', handleFocus);
        floatField.addEventListener('blur', handleBlur);
    };

    // get DOM elements
    const init = () => {
        const floatContainers = document.querySelectorAll('.float-container');

        floatContainers.forEach((element) => {
            if (element.querySelector('input').value) {
                element.classList.add('active');
            }

            bindEvents(element);
        });
    };

    return {
        init: init
    };
})();

FloatLabel.init();

function onFieldChange(field, regex) {
    let errMessage = "";
    if ((document.getElementById(field).value) == "") {
        errMessage = "Field cannot be empty";
    } else if ((document.getElementById(field).value).length < 2) {
        errMessage = "Field must be contain atleast two charcter";
    } else if (regex.test(document.getElementById(field).value) == false) {
        errMessage = "Not appropriately entered";
    }

    var field = document.getElementById(field).parentElement;
    if (errMessage !== "") {
        field.style.borderColor = "red";
        field.childNodes[1].style.color = "red";
        field.title = errMessage;
    } else {
        field.style.borderColor = "green";
        field.childNodes[1].style.color = "green";
        field.title = "";
    }
}

function confirmPassword() {
    let password = document.getElementById('password');
    let confirmPassword = document.getElementById('confirm-password');
    if (password.value !== confirmPassword.value) {
        confirmPassword.parentElement.title = "Password didn't matched";
        confirmPassword.parentElement.childNodes[1].style.color = "red";
        confirmPassword.parentElement.style.borderColor = "red";
    } else {
        confirmPassword.parentElement.title = "";
        confirmPassword.parentElement.childNodes[1].style.color = "green";
        confirmPassword.parentElement.style.borderColor = "green";
    }
}

function validateTextInputs(fields) {
    let valid = true;
    for (let i = 0; i < fields.length; i++) {
        let field = document.getElementById(fields[i]);
        if (field.value === "" && field.parentElement.style.borderColor !== "red") {
            field.parentElement.style.borderColor = "red";
            field.parentElement.childNodes[1].style.color = "red";
        }
        if (field.parentElement.style.borderColor === "red") {
            valid = false;
        }
    }
    return valid;
}

function validateRadioInputs(fields) {
    let valid = false;
    for (let i = 0; i < fields.length; i++) {
        valid = valid || document.getElementById(fields[i]).checked;
    }
    let parent = document.getElementById(fields[0]).parentElement.parentElement;
    if (valid) {
        parent.childNodes[1].style.color = "green";
        parent.title = "Must select one option";
        return true;
    } else {
        parent.childNodes[1].style.color = "red";
        parent.title = "";
        return false;
    }
}

function validateSelectInput(id) {
    let field = document.getElementById(id);
    valid = (field.value !== "");
    if (!valid) {
        field.parentElement.childNodes[1].style.color = "red";
        field.parentElement.title = "Must select an option."
    } else {
        field.parentElement.childNodes[1].style.color = "green";
        field.parentElement.title = ""
    }
    return valid;
}

function validateRegisterForm() {
    let fields = [
        'first-name',
        'last-name',
        'email',
        'password',
        'confirm-password',
        'contact'
    ];
    let valid = validateTextInputs(fields);
    valid = validateRadioInputs(['male', 'female']) && valid;
    valid = validateSelectInput('organisation') && valid;
    return valid;
}

let typeOfVehicle;

function validateVehicleForm() {
    let fields = [
        'car-name',
        'vehicle-number',
        'employee-id'
    ];
    let valid = validateTextInputs(fields);
    valid = validateSelectInput('vehicle-type') && valid;
    if (valid) {
        typeOfVehicle = document.getElementById('vehicle-type').value;
        document.getElementById('vehicle-register-form').style.display = "none";
        document.getElementById('pass-type-form').style.display = "block";
    }
    return valid;
}

var xmlHttp = new XMLHttpRequest();
var theUrl = "http://api.currencylayer.com/live?access_key=2243dba5ea20e9d54f41fc7da3486f04&currencies=USD,INR,JPY";
xmlHttp.open("GET", theUrl, false);
xmlHttp.send(null);
var currencyRates = JSON.parse(xmlHttp.responseText).quotes;
var currentCurrency = document.getElementById('current-currency').innerHTML;

function exchangeCurrency(amount, targetCurrency) {
    if (targetCurrency === "INR") {
        return amount;
    } else if (targetCurrency === "USD") {
        return Math.round(amount / currencyRates.USDINR * 100) / 100;
    } else if (targetCurrency === "YEN") {
        return Math.round(amount * currencyRates.USDJPY / currencyRates.USDINR * 100) / 100;
    }
}

function getCurrencyString(amount) {
    let symbol;
    if (currentCurrency === "INR") {
        symbol = "&#8377; ";
    } else if (currentCurrency === "USD") {
        symbol = "$ ";
    } else if (currentCurrency === "YEN") {
        symbol = "&#165; ";
    }
    return symbol + exchangeCurrency(amount, currentCurrency);
}

function calculate() {
    var type = typeOfVehicle;
    let amount;
    document.getElementById("current-currency").innerHTML = currentCurrency;
    var passtype = document.getElementById('pass-type').value;

    if (passtype === "") {
        return false;
    }

    if (type == "cycle") {
        if (passtype == "daily") {
            amount = 5;
        } else if (passtype == "monthly") {
            amount = 100;
        } else if (passtype == "yearly") {
            amount = 500;
        }
    } else if (type == "two-wheeler") {
        if (passtype == "daily") {
            amount = 10;
        } else if (passtype == "monthly") {
            amount = 200;
        } else if (passtype == "yearly") {
            amount = 1000;
        }
    } else if (type == "four-wheeler") {
        if (passtype == "daily") {
            amount = 20;
        } else if (passtype == "monthly") {
            amount = 500;
        } else if (passtype == "yearly") {
            amount = 3500;
        }
    }
    document.getElementById('amount').innerHTML = getCurrencyString(amount);
    document.getElementById('price').value = exchangeCurrency(amount, 'USD');
    return true;
}

function changeCurrency(changeTo) {
    currentCurrency = changeTo;
    document.getElementById('current-currency').innerHTML = currentCurrency;
}

function stopRefresh(event) {
    event.preventDefault();
}

function validateLoginForm() {
    let fields = [
        'email',
        'password'
    ];
    let valid = validateTextInputs(fields);
    return valid;
}