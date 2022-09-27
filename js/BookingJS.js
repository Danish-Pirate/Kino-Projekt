const seatID = [];

function seatNumbering(){
    
    var seats = "";
    var seatNum = 1;
    var rowNum = 1;
    const seatNumberIDs = [];


for(let i = 0; i < 240; i++){
    
    seatID.push("seat_id_" + i);
    
    seats = seats + '<div class="cinema_one_seat_class" id="seat_id_' + i +'"  onclick="seatColorChange();tickets();">' + seatNum + '-' + rowNum + '</div>';
    
    if(seatNum == 12){
        seatNum = 0;
        rowNum++;
    }

    seatNum++;
    
}

document.getElementById('cinema_one_grid_id').innerHTML = seats;

const divs = document.querySelectorAll('.cinema_one_seat_class');
Array.from(divs).forEach(div => {
    div.addEventListener('click', tickets);
});

const div = document.querySelectorAll('.cinema_one_seat_class');
Array.from(divs).forEach(div => {
    div.addEventListener('click', seatColorChange);
});
const seatColors = ['bookedColor'];

let enumerator = 0;

function seatColorChange(){

    if(enumerator < seatColors.length +1){
        enumerator += 1;
    }
    else{
        enumerator = 0;
    }

    this.classList.add(seatColors[enumerator]);
    this.classList.remove(seatColors[enumerator-1]);

    
}

const message = ['hej']
let message_count = 0;
function tickets(){
    if(message_count < message.length + 1){
        message_count += 1;
    }
    else{
        message_count = 0;
    }
    var ticket= "";
    
    
    this.classList.add(message[2]);
    this.classList.remove(message[ticket = '<p> ' +message+ '</p>']);


    document.getElementById('ticket_id').innerHTML = ticket;
}
}
