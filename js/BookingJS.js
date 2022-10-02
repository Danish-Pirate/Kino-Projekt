const seatID = [];
const seatColors = ['bookedColor'];
var seatClickedID;
var ticketList = "";

function seatNumbering(){
    
    var seats = "";
    var row = "";
    var seatNum = 1;
    var rowNum = 1;
    const seatNumberIDs = [];
    var gridcount = 1;
    var seat_id = 0;


for(let i = 0; i < 260; i++){
    
    
    if (gridcount == 1){
        seats = seats + '<row class="row_class">' + "række: " + rowNum + '</row>';
    }else{
        seat_id++;
        seats = seats + '<seats class="cinema_one_seat_class" id="seat_id_' + seat_id +'"  onclick="getSeatIDFromClick(this.id);seatColorChange();handleTicket()">' +"sæde: " + seatNum+ '</seats>';
        seatID.push("seat_id_" + seat_id);
        if(seatNum==12){
            seatNum = 1;
        }else{
            seatNum++;
        }
    }
    gridcount++;
    if(gridcount == 13){
        rowNum++;
        gridcount = 0;
    }
}

document.getElementById('cinema_one_grid_id').innerHTML = seats;
}

function handleTicket(){
   
    if($("#" + seatClickedID).css("background-color") != "rgb(230, 230, 250)"){
    ticket = '<ticket added_ticket_id="ticket' + seatClickedID +'">' + seatClickedID + '</ticket><br>';

    this.ticketList = this.ticketList + ticket;    
    
    }
   
    if($("#" + seatClickedID).css("background-color") != "rgb(255, 0, 0)"){

        removeTicket = "" + '<ticket added_ticket_id="ticket' + seatClickedID +'">' + seatClickedID + '</ticket><br>';
       
        this.ticketList = this.ticketList.replace(removeTicket, "");

    }

    document.getElementById('ticket_id').innerHTML = this.ticketList;
    
}



function seatColorChange(){    
            
        if($("#" + seatClickedID).css("background-color") != "rgb(255, 0, 0)"){

            $("#" + seatClickedID).css("background-color", "red");
            
        }
        else {
            $("#" + seatClickedID).css("background-color", "lavender");

        }
        
}

function getSeatIDFromClick(clicked_id){

    seatClickedID = clicked_id;
}





/*
// Føjer 'tickets' funktionen til '.cinema_one_seat_class' når man klikker på sæderne.
const divs = document.querySelectorAll('.cinema_one_seat_class');
Array.from(divs).forEach(div => {
    div.addEventListener('click', tickets);
});

// Føjer 'seatColorChange' funktionen til '.cinema_one_seat_class' når man klikker på sæderne.
const div = document.querySelectorAll('.cinema_one_seat_class');
Array.from(div).forEach(div => {
    div.addEventListener('click', seatColorChange);
});

// Føjer 'getSeatIDFromClick' funktionen til '.cinema_one_seat_class' når man klikker på sæderne.
const seatIDs = document.querySelectorAll('.cinema_one_seat_class');
Array.from(seatIDs).forEach(seatIDs => {
    seatIDs.addEventListener('click', getSeatIDFromClick);
});



// seatColors og enumerator brugt til seatColorChange(). 'bookedColor' og 'bookedColor2' er CSS-klasser.
const seatColors = ['bookedColor', 'bookedColor2'];

let enumerator = 0;

// Bestemmer farven på sæderne i vores grid onclick. Virker ikke perfekt hvis man prøver at ændre
// flere sæder's farve på én gang.
function seatColorChange(){
   
    if(this.enumerator < seatColors.length){
        this.enumerator += 2;

        this.classList.add(seatColors[this.enumerator-1]);
        this.classList.remove(seatColors[this.enumerator-2]);
    }
    else{
        this.enumerator = 0;

        this.classList.add(seatColors[this.enumerator]);
        this.classList.remove(seatColors[this.enumerator+1]);
    }

}


// message_count brugt i tickets funktionen.
let message_count = 0;

function tickets(){
    let clickCiunt = 0;

    const buttons = document.getElementsByTagName("seats");
    var result1 = document.getElementById('ticket_id');

const buttonPressed1 = message => {
    result1.innerHTML = `<em>Seat ID:</em> <strong>${message.target.id}</strong>`;
}
    if(message_count < 1) {
        for (let button of buttons) {
            button.addEventListener('click', buttonPressed1);
         }


  
    
        message_count += 1;
    } else {
        for (let button of buttons) {
            button.removeEventListener('click', buttonPressed1);
        }

       
    }
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
*/

