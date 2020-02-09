let url = new URL(window.location);
let registerId = url.searchParams.get("registrationId");

if (registerId != null) {
    document.getElementById('customer-register-form').style.display = "none";
    document.getElementById('vehicle-register-form').style.display = "block";
    document.getElementById('registrationId').innerHTML = registerId;
    document.getElementById('registerId').value = registerId;
}