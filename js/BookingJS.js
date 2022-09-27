const seatID = [];

function seatNumbering(){
    
    var seats = "";
    var seatNum = 1;
    var rowNum = 1;
    const seatNumberIDs = [];


for(let i = 0; i < 240; i++){
    
    seatID.push("seat_id_" + i);
    
    seats = seats + '<seats class="cinema_one_seat_class" id="seat_id_' + i +'"  onclick="seatColorChange();tickets();">' + seatNum + '-' + rowNum + '</seats>';
    
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
Array.from(div).forEach(div => {
    div.addEventListener('click', seatColorChange);
});

const seatIDs = document.querySelectorAll('.cinema_one_seat_class');
Array.from(seatIDs).forEach(seatIDs => {
    seatIDs.addEventListener('click', getSeatIDFromClick);
});


const seatColors = ['bookedColor'];

let enumerator = 0;

function seatColorChange(){

    if(enumerator < seatColors.length){
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
    var ticket= "";
    if(message_count < message.length){
        message_count += 1;
        this.classList.remove(message[ticket = '']);
    }
    else{
        message_count = 0;
        this.classList.remove(message[ticket = '<p> ' +message+ '</p>']);
    }
    

    document.getElementById('ticket_id').innerHTML = ticket;
}

function getSeatIDFromClick(){

    const buttons = document.getElementsByTagName("seats");
var result = document.getElementById("price_infobox_id");

 const buttonPressed = e => { 
  result.innerHTML = `ID of <em>${e.target.innerHTML}</em> is <strong>${e.target.id}</strong>`;
}

for (let button of buttons) {
  button.addEventListener("click", buttonPressed);
}
    
    




}






}
