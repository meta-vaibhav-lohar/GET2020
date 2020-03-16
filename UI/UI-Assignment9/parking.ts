
var currentField: string;
let currentForm: number;
var daily = 5, monthly = 100, yearly = 500;

/* Class representing employee */
class Employee {

    registerationForm(): void {

        document.body.style.backgroundColor = "#7FDBFF";

        (<HTMLElement>document.getElementById("addEmp")).style.display = "none";
        (<HTMLElement>document.getElementById("u_Registration")).style.display = "block";
        (<HTMLElement>document.getElementById("label")).style.display = "block";
        (<HTMLElement>document.getElementById("empName")).style.display = "block";

        currentField = "name";
        currentForm = 1;

        (<HTMLElement>document.getElementById("coverImg")).style.display = "none";
    }


    employeeBlur(): boolean {

        if (currentForm == 2) {
            veh.vehicleBlur();
            return false;
        }

        let label: HTMLElement = document.getElementById("labelText") as HTMLElement;

        switch (currentField) {

            case "name":
                let name: string = (<HTMLInputElement>document.getElementById("ename")).value;
                

                if (!(/^[A-z ]{2,}$/.test(name))) {

                    (<HTMLElement>document.getElementById("error")).innerHTML = "Please Enter Valid Name";
                    return false;
                } else {
                    (<HTMLElement>document.getElementById("error")).innerHTML = " ";
                }

                label.innerHTML = "Hi " + name + " May I know your Gender?";

                (<HTMLElement>document.getElementById("empName")).style.display = "none";
                (<HTMLElement>document.getElementById("empGender")).style.display = "block";
                currentField = "gender";

                break;

            case "gender":

                // let gender: NodeList = document.getElementsByName("egender") as NodeList;
                let gender : NodeListOf<HTMLElement>= document.getElementsByName("egender") ;

                if (!gender[0].checked && !gender[1].checked) {
                    (<HTMLElement>document.getElementById("error")).innerHTML = "Please Select Gender";
                    return false;
                } else {
                    (<HTMLElement>document.getElementById("error")).innerHTML = " ";
                }

                label.innerHTML = " You must be having a email Id";

                (<HTMLElement>document.getElementById("empGender")).style.display = "none";
                (<HTMLElement>document.getElementById("empEmail")).style.display = "block";
                currentField = "email";
                break;

            case "email":
                let email: string = (<HTMLInputElement>document.getElementById("eemail")).value;
                if (!(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(email))) {
                    (<HTMLElement>document.getElementById("error")).innerHTML = "Please Enter Valid Email Address";
                    return false;
                } else {
                    (<HTMLElement>document.getElementById("error")).innerHTML = " ";
                }
                label.innerHTML = "Please choose a password";
                (<HTMLElement>document.getElementById("empEmail")).style.display = "none";
                (<HTMLElement>document.getElementById("empPass")).style.display = "block";
                (<HTMLElement>document.getElementById("empCnfrmPass")).style.display = "block";
                currentField = "password";

                break;

            case "password":
                let password = (<HTMLInputElement>document.getElementById("epass")).value;
                
                if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(password))) {
                    (<HTMLElement>document.getElementById("error")).innerHTML = "Password should contain Uppercase, Lowercase,Special character,Numeric and minimum 8 characters";
                    return false;
                } else {
                    (<HTMLElement>document.getElementById("error")).innerHTML = " ";
                }

                
                let employeeMatchPassword: string = (<HTMLInputElement>document.getElementById("ecnfrmpass")).value;

                if (password != employeeMatchPassword) {
                    (<HTMLElement>document.getElementById("error")).innerHTML = "Password Doesn't Match";
                    return false;
                } else {
                    (<HTMLElement>document.getElementById("error")).innerHTML = " ";
                }
                label.innerHTML = "Please Enter your Contact Number  ...";
                (<HTMLElement>document.getElementById("empPass")).style.display = "none";
                (<HTMLElement>document.getElementById("empCnfrmPass")).style.display = "none";
                (<HTMLElement>document.getElementById("empContact")).style.display = "block";
                (<HTMLElement>document.getElementById("next1")).style.display = "block";
                currentField = "contact";
        }
        return true;
    }
}
function validatePassword() {

    let employeePassword = (<HTMLInputElement>document.getElementById("epass")).value;
    (<HTMLElement>document.getElementById("epass")).style.borderWidth = "thick";
    if (employeePassword.length < 8) {
        (<HTMLElement>document.getElementById("epass")).style.borderColor = "red";
        (<HTMLElement>document.getElementById("error")).innerHTML = "Password Should be of minimum 8 characters";
        return false;
    } else if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(employeePassword))) {
        (<HTMLElement>document.getElementById("epass")).style.borderColor = "orange";
        (<HTMLElement>document.getElementById("error")).innerHTML = "Password should contain Uppercase, Lowercase and Numeric";
        return false;
    } else {
        (<HTMLElement>document.getElementById("epass")).style.borderColor = "green";
        (<HTMLElement>document.getElementById("error")).innerHTML = " ";
        return true;
    }
}

/* class representing a vehicle */
class Vehicle {

    constructor() { };

    /*  shows first input of vehicle form */
    vehicleForm(): boolean {

        let employeeContact:string = (<HTMLInputElement>document.getElementById("ecnumber")).value;
        if (!(/^[0-9]{10}$/.test(employeeContact))) {
            (<HTMLElement>document.getElementById("error")).innerHTML = "Please Enter Valid Contact Number";
            return false;
        } else {
            (<HTMLElement>document.getElementById("error")).innerHTML = " ";
        }

        (<HTMLElement>document.getElementById("empContact")).style.display = "none";
        (<HTMLElement>document.getElementById("next1")).style.display = "none";

        currentField = "vehName";
        currentForm = 2;

        document.body.style.backgroundColor = "#ffae68";
        (<HTMLElement>document.getElementById("u_Registration")).style.display = "none";
        (<HTMLElement>document.getElementById("v_Registration")).style.display = "block";

        (<HTMLElement>document.getElementById('labelText')).innerHTML = "May I know the Name of your Vehicle";
        (<HTMLElement>document.getElementById("vehName")).style.display = "block";
        (<HTMLElement>document.getElementById("vname")).focus();
        currentField = "vehName";

        return true
    }

    /* switch case for vehicle  form for switching input fields */
    vehicleBlur(): boolean {

        let vehicleName:string = (<HTMLInputElement>document.getElementById("vname")).value;;
        switch (currentField) {

            case "vehName":
                if (vehicleName == "") {
                    (<HTMLElement>document.getElementById("error")).innerHTML = "This field is Required";
                    return false;
                }
                (<HTMLElement>document.getElementById("error")).innerHTML = " ";
                (<HTMLElement>document.getElementById("vehName")).style.display = "none";
                (<HTMLElement>document.getElementById('labelText')).innerHTML = " Whats the type of " + vehicleName;
                (<HTMLElement>document.getElementById("vehType")).style.display = "block";
                currentField = "vehType";

                break;

            case "vehType":

                let vehicleType:string = (<HTMLInputElement>document.getElementById("vtype")).value;

                if (vehicleType == "") {
                    (<HTMLElement>document.getElementById("error")).innerHTML = "This field is Required";
                    return false;
                }
                (<HTMLElement>document.getElementById("error")).innerHTML = "";

                (<HTMLElement>document.getElementById("vehType")).style.display = "none";
                (<HTMLElement>document.getElementById('labelText')).innerHTML = "Can you please Mention the number of " + vehicleName;
                (<HTMLElement>document.getElementById("vehNumber")).style.display = "block";
                currentField = "vehNumber";

                break;

            case "vehNumber":
                let vehNumber: string = (<HTMLInputElement>document.getElementById("vnumber")).value;
                

                if (!(/^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}/.test(vehNumber))) {
                    (<HTMLElement>document.getElementById("error")).innerHTML = "Vehicle Number should be of proper type.";
                    return false;
                }
                if (vehNumber == "") {
                    (<HTMLElement>document.getElementById("error")).innerHTML = "This field is Required";
                    return false;
                }
                (<HTMLElement>document.getElementById("error")).innerHTML = " ";

                (<HTMLElement>document.getElementById("vehNumber")).style.display = "none";
                (<HTMLElement>document.getElementById('labelText')).innerHTML = "Tell something about " + vehicleName;
                (<HTMLElement>document.getElementById("vehDescription")).style.display = "block";
                (<HTMLElement>document.getElementById("next2")).style.display = "block";
                currentField = "vehDescription";
        }
        return true;
    }
}

/* class for Plans and pricing */
class Plan {
    constructor() { };

    /* opens up the plan and pricing form */
    planForm(): void {

        (<HTMLElement>document.getElementById("v_Registration")).style.display = "none";
        (<HTMLElement>document.getElementById("p_Registration")).style.display = "block";

        document.body.style.backgroundColor = "#DDDDDD";
        (<HTMLElement>document.getElementById("vehDescription")).style.display = "none";
        (<HTMLElement>document.getElementById("next2")).style.display = "none";

        (<HTMLElement>document.getElementById('labelText')).innerHTML = "Choose Currency for your Plan";
        (<HTMLElement>document.getElementById("currType")).style.display = "block";

        currentField = "currency";
        currentForm = 3;
    }
    /* on submit of plan and pricing form */
    submitForm(): void {

        var moneypass = '';
        (<HTMLElement>document.getElementById("p_Registration")).style.display = "none";
        document.getElementsByName("passtype").forEach(function (item) {
            if ((<HTMLInputElement>item).checked) { moneypass = (<HTMLInputElement>item).value }
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
        (<HTMLElement>document.getElementById('labelText')).innerHTML = "Thank you for registering " + (<HTMLInputElement>document.getElementById("ename")).value + " Kindly Pay:" + moneypass;
        (<HTMLElement>document.getElementById("plans")).style.display = "none";
        (<HTMLElement>document.getElementById("submit")).style.display = "none";
        (<HTMLElement>document.getElementById("currency")).style.display = "none";
    }
    /* showing available plans according to vehicle selected */
    showPrice(): void {

        var curr = (<HTMLInputElement>document.getElementById("currency")).value;
        let plan:HTMLElement = <HTMLInputElement>document.getElementById("plans");

        plan.style.display = "block";
        var v = (<HTMLInputElement>document.getElementsByName("vehicleType")[0].children[0]).value;
        (<HTMLElement>document.getElementById("submit")).style.display = "block";

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
                (<HTMLElement>document.getElementById("daily")).innerHTML = "" + daily;
                (<HTMLElement>document.getElementById("monthly")).innerHTML = "" + monthly;
                (<HTMLElement>document.getElementById("yearly")).innerHTML = "" + yearly;
                break;
            case "USD":
                (<HTMLElement>document.getElementById("daily")).innerHTML = (daily / 71.74).toFixed(2);
                (<HTMLElement>document.getElementById("monthly")).innerHTML = (monthly / 71.74).toFixed(2);
                (<HTMLElement>document.getElementById("yearly")).innerHTML = (yearly / 71.74).toFixed(2);
                break;
            case "YEN":
                (<HTMLElement>document.getElementById("daily")).innerHTML = (daily / 0.68).toFixed(2);
                (<HTMLElement>document.getElementById("monthly")).innerHTML = (monthly / 0.68).toFixed(2);
                (<HTMLElement>document.getElementById("yearly")).innerHTML = (yearly / 0.68).toFixed(2);

        }
    }
}


let emp = new Employee();
let veh = new Vehicle();
let plan = new Plan();

/* event listener for enter key */
window.addEventListener('keypress', function (e) {
    if (e.keyCode == 13) {
        emp.employeeBlur();
    }
}, false);

/* redirects to emp registration form */
function registerationFormCaller(): void {
    emp.registerationForm();
}
/* redirects to vehicle form */
function vehicleFormCaller(): void {
    veh.vehicleForm();
}

/* redirects to plan form */
function planFormCaller(): void {
    plan.planForm();
}

/* redirects to submit form method*/
function submitFormCaller(): void {

    plan.submitForm();

}

/* redirects to show price method */
function showPriceCaller(): void {
    plan.showPrice();
}