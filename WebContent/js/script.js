// Include truYum form validation functions here
function validation()
{
    var a = document.forms.["form"]["txtName"].value;
    if(a==""){
        alert("Title is required.");
        document.forms.["form"]["txtName"].focus();
        return false;
    }
    if ((a.length < 2) || (a.length > 30))
    {
        alert("Title should have 2 to 65 characters.");
        document.forms.["forms"]["txtName"].select();
        return false;
    }
    var a = document.forms.["forms"]["txtPrice"].value;
    if(a=="")
    {
        alert("Price is required.");
        document.forms.["form"]["txtPrice"].focus();
        return false;
    }
    if(/[^0-9/]/.test(b))
    {
        alert("Price has to be a number.");
        document.forms.["forms"]["txtPrice"].select();
        return false;
    }
    var a = document.forms.["form"]["txtDoL"].value;
    if(a=="")
    {
        alert("Date of Launch is required.");
        document.forms.["form"]["txtDoL"].focus();
        return false;
    }
    var a = document.forms.["form"]["Category"].value;
    if(a=="")
    {
        alert("Category is required.");
        document.forms.["form"]["Category"].focus();
        return false;
    }
}
