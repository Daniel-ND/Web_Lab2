let canvas = document.getElementById('canvas');
let context = canvas.getContext('2d');
let canvasCenter = canvas.width * 0.5;
Rval = 1;
canvas.addEventListener("click", clickOnCanvas);


let gr_const = 120;
make_base();
function make_base()
{
    let img = new Image();
    img.src = 'img/gr2.jpg';
    img.onload = function(){
        context.drawImage(img, 0, 0, 300, 300);
    }
}

function selectedR() {
    Rval = parseFloat(document.getElementById("r").value);
    redrawCanvas();
}

function val(){
    let y = document.getElementById("y");
    let x = document.getElementById("x");
    let r = document.getElementById("r");
    if (y.value === "" || +y.value !== +y.value || y.value >= 3 || y.value <= -3) {
        y.style.borderColor = "crimson";
    }
    else {
        y.style.borderColor = "darkgrey";
        Yval = parseFloat(y.value);
        Xval = parseFloat(x.value);
        Rval = parseFloat(r.value);
        $.post("controller", {X: Xval, Y: Yval, R: Rval}, function (html) {
            document.getElementById("result").innerHTML = html;
            redrawCanvas();
        });
    }
    return false;
}

function redrawCanvas(){
    let img = new Image();
    img.src = 'img/gr2.jpg';
    img.onload = function(){
        context.drawImage(img, 0, 0, 300, 300);
        var table = document.getElementById("result");
        var tr = table.getElementsByTagName("tr");
        for (var i = 1; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td");
            X = parseFloat(td[0].textContent);
            Y = parseFloat(td[1].textContent);
            context.beginPath();
            context.fillStyle = "rgb(0, 0, 0)";
            if (i == tr.length - 1) {
                if (td[3].textContent == "true") context.fillStyle = "rgb(0, 255, 0)";
                else context.fillStyle = "rgb(255, 0, 0)";
            }
            context.fillRect(canvasCenter + X / Rval * gr_const - 2.5, canvasCenter - Y / Rval * gr_const - 2.5, 5, 5);
        }
    }
}

function clickOnCanvas(event){
    let {x, y} = getCursorPosition(event);
    Xval = (x - canvasCenter)/gr_const*Rval;
    Yval = -(y - canvasCenter)/gr_const*Rval;
    $.post("controller", {X: Xval, Y: Yval, R: Rval}, function (html) {
        document.getElementById("result").innerHTML = html;
        redrawCanvas();
    });
}

function getCursorPosition(event) {
    const rect = canvas.getBoundingClientRect();
    let x = event.clientX - rect.left;
    let y = event.clientY - rect.top;
    return {x, y};
}




