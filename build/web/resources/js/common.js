function Selected(a) {
    var label = a.value;
    if (label == "standart") {
        document.getElementById("Block1").style.display = 'block';
        document.getElementById("Block2").style.display = 'none';
        document.getElementById("Block3").style.display = 'none';
    } else if (label == "sud") {
        document.getElementById("Block1").style.display = 'none';
        document.getElementById("Block2").style.display = 'block';
        document.getElementById("Block3").style.display = 'none';
    } else if (label == "Lang") {
        document.getElementById("Block1").style.display = 'none';
        document.getElementById("Block2").style.display = 'none';
        document.getElementById("Block3").style.display = 'block';
    }
}

function Reload(a) {
    var label = a;
    if (label == "standart") {
        document.getElementById("Block1").style.display = 'block';
        document.getElementById("Block2").style.display = 'none';
        document.getElementById("Block3").style.display = 'none';
    } else if (label == "sud") {
        document.getElementById("Block1").style.display = 'none';
        document.getElementById("Block2").style.display = 'block';
        document.getElementById("Block3").style.display = 'none';
    } else if (label == "Lang") {
        document.getElementById("Block1").style.display = 'none';
        document.getElementById("Block2").style.display = 'none';
        document.getElementById("Block3").style.display = 'block';
    }
}