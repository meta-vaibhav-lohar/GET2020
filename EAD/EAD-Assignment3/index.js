function element(id) {
    return document.getElementById(id).value;
}

function addStudent(obj) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/Student/add", true);

    var jsonString = JSON.stringify(obj);
    console.log(jsonString);
    xhr.setRequestHeader("Content-Type", "application/json");


    xhr.onreadystatechange = function() {
        // console.log('READYSTATE: ', xhr.readyState);
        if (this.readyState == 4) {
            var response = this.responseText;
            var obj = JSON.parse(response);
            if (obj["code"] == 406) {
                alert("Email address is already available");
                location.reload();
            } else {
                alert("User Added");
                location.reload();
            }
        }
    }

    xhr.send(jsonString)

}

function addSubmit() {

    var firstName = element("firstNameId");
    var lastName = element("lastNameId");
    var fatherName = element("fatherNameId");
    var email = element("emailId");
    var className = element("classId");
    var age = element("ageId");

    var obj = {
        "firstName": firstName,
        "lastName": lastName,
        "fatherName": fatherName,
        "email": email,
        "classname": className,
        "age": age
    }
    addStudent(obj)
}

function searchStudents(obj) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/Student/search", true);

    var jsonString = JSON.stringify(obj);
    console.log(jsonString);
    xhr.setRequestHeader("Content-Type", "application/json");


    xhr.onreadystatechange = function() {
        // console.log('READYSTATE: ', xhr.readyState);
        if (this.readyState == 4) {
            var response = this.responseText;
            var obj = JSON.parse(response);
            document.getElementById("det1").style.display = "none";
            document.getElementById("det2").style.display = "";
            console.log(obj);
            var count = Object.keys(obj).length;
            var index = 0;
            for (index in obj) {
                ele = obj[index];

                var table = document.getElementById("myTableData");
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);

                row.insertCell(0).innerHTML = ele["firstName"];
                row.insertCell(1).innerHTML = ele["lastName"];
                row.insertCell(2).innerHTML = ele["fatherName"];
                row.insertCell(3).innerHTML = ele["email"];
                row.insertCell(4).innerHTML = ele["classname"];
                row.insertCell(5).innerHTML = ele["age"];
            }
        }
    }

    xhr.send(jsonString)

}

function search() {

    var firstName = element("firstNameId");
    var lastName = element("lastNameId");
    var obj = {
        "firstName": firstName,
        "lastName": lastName
    }
    searchStudents(obj)
}



function editRow(obj) {
    console.log("hit");
    document.getElementById("update").style.display = "";
    var index = obj.parentNode.parentNode.rowIndex;
    console.log(index);
    document.getElementById("update").innerHTML += "<input type='hidden' id='field' name='custId' value= '" + index + "'>";

}

function sendUpdates() {
    var index = document.getElementById("field").value;
    console.log(index);
    var table = document.getElementById("myTableData");
    var row = table.rows[index];
    var firstName = row.cells[1].innerText;
    var lastName = row.cells[2].innerText;
    var fatherName = row.cells[3].innerText;
    var email = row.cells[4].innerText;
    var className = row.cells[5].innerText;
    var age = row.cells[6].innerText;
    var detail = {
        "firstName": firstName,
        "lastName": lastName,
        "fatherName": fatherName,
        "email": email,
        "classname": className,
        "age": age
    }

    var firstName = element("firstNameId");
    var lastName = element("lastNameId");
    var fatherName = element("fatherNameId");
    var email = element("emailId");
    var className = element("classId");
    var age = element("ageId");

    var updates = {
        "firstName": firstName,
        "lastName": lastName,
        "fatherName": fatherName,
        "email": email,
        "classname": className,
        "age": age
    }

    objects = { "details": JSON.stringify(detail), "updates": JSON.stringify(updates) };
    console.log(objects)
    jsonString = JSON.stringify(objects)
    console.log(jsonString);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/Student/show", true);

    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
        if (this.readyState == 4) {
            var response = this.responseText;
            var result = JSON.parse(response);
            if (result["code"] == 200) {
                alert("Updated");
                location.reload();
            } else {
                alert(result["msg"]);
                location.reload();
            }
        }
    }
    xhr.send(jsonString);

}

function addRow(obj) {

    var count = Object.keys(obj).length;
    var index = 0;
    for (index in obj) {
        ele = obj[index];

        var table = document.getElementById("myTableData");
        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        row.insertCell(0).innerHTML = '<button class="btn" onclick="editRow(this)">Edit</button>';
        row.insertCell(1).innerHTML = ele["firstName"];
        row.insertCell(2).innerHTML = ele["lastName"];
        row.insertCell(3).innerHTML = ele["fatherName"];
        row.insertCell(4).innerHTML = ele["email"];
        row.insertCell(5).innerHTML = ele["classname"];
        row.insertCell(6).innerHTML = ele["age"];
    }

}

function fetchStudent() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8080/Student/show", true);

    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
        if (this.readyState == 4) {
            var response = this.responseText;
            var obj = JSON.parse(response);
            addRow(obj);
        }
    }
    xhr.send();
}