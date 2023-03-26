document.getElementById("btn").onclick = function(){
    // alert()
    var a = document.getElementById("x1").value;
    var b = document.getElementById("x2").value;
    var c = document.getElementById("x3").value;
    var d = document.getElementById("x4").value;
    var e = document.getElementById("x5").value;

    // console.log(a,b,c);
    var jsObj = {
        id:a,
        name:b,
        age:c,
        sal:d,
        departmentId:e
    };

    console.log(jsObj);

    //objecxt to striong

    var params = JSON.stringify(jsObj);
    console.log(params);

    var rec = new XMLHttpRequest();
    

    rec.onreadystatechange = function(){
        console.log(rec.readyState , rec.status);
    }

    rec.open('POST','http://localhost:8080/ModernWebApp/api/employees/');

    rec.setRequestHeader('Content-Type', 'application/json');

    rec.send(params);
    alert("Employee Added");
}