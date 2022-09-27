const seatID = [];

function seatNumbering(){
    
    var seats = "";
    var seatNum = 1;
    var rowNum = 1;
    const seatNumberIDs = [];


for(let i = 0; i < 240; i++){
    
    seatID.push("seat_id_" + i);
    
    seats = seats + '<div class="cinema_one_seat_class" id="seat_id_' + i +'"  onclick="seatColorChange()">' + seatNum + '-' + rowNum + '</div>';
    
    if(seatNum == 12){
        seatNum = 0;
        rowNum++;
    }

    seatNum++;
    
}

document.getElementById('cinema_one_grid_id').innerHTML = seats;

const divs = document.querySelectorAll('.cinema_one_seat_class');
Array.from(divs).forEach(div => {
    div.addEventListener('click', seatColorChange);
});

const seatColors = ['bookedColor'];

let enumerator = 0;

function seatColorChange(){

    if(enumerator < seatColors.length + 1){
        enumerator += 1;
    }
    else{
        enumerator = 0;
    }

    this.classList.add(seatColors[enumerator]);
    this.classList.remove(seatColors[enumerator-1]);

}
}


/*
const seatID = [];

function seatNumbering(){
    
    var seats = "";
    var seatNum = 1;
    var rowNum = 1;
    const seatNumberIDs = [];


for(let i = 0; i < 240; i++){
    
    seatID.push("seat_id_" + i);
    
    seats = seats + '<div class="cinema_one_seat_class" id="seat_id_' + i +'"  onclick="seatColorChange()">' + seatNum + '-' + rowNum + '</div>';
    
    if(seatNum == 12){
        seatNum = 0;
        rowNum++;
    }

    seatNum++;
    
}

document.getElementById('cinema_one_grid_id').innerHTML = seats;
}

function seatColorChange(){



    for(let i = 0; i < 240; i++){
    document.getElementById('seat_id_' + i).style.backgroundColor = 'yellow';
    }

}
*/





/*const allSeats = document.querySelectorAll('.cinema_one_seat_class');

Array.from(allSeats).forEach(div => {
    div.addEventListener('click', seatColorChange);
});

const seatColors = ['bookedColor'];

let enumerator = 0;

function seatColorChange(){

    if(enumerator < seatColors.length + 1){
        enumerator += 1;
    }
    else{
        enumerator = 0;
    }

    this.classList.add(seatColors[enumerator]);
    this.classList.remove(seatColors[enumerator-1]);

}*/

