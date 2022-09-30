const seatID = [];


// Laver gridden til sæderne.
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
        seats = seats + '<row class="row_class">' + "row: " + rowNum + '</row>';
    }else{
        seat_id++;
        seats = seats + '<seats class="cinema_one_seat_class" id="seat_id_' + seat_id +'"  onclick="seatColorChange();tickets();">' +"sæde: " + seatNum+ '</seats>';
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
/*
const seatIDs = document.querySelectorAll('.cinema_one_seat_class');
Array.from(seatIDs).forEach(seatIDs => {
    seatIDs.addEventListener('click', getSeatIDFromClick);
});
*/


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




// Gør et forsøg på at få et sæde's ID onclick til at poppe op i registrationBox.
// Skal kunne vælge flere sæder på én gang.
// Skal senere også kunne gemme disse ID'er som nogle endpoints.
let clickCiunt = 1;
function tickets(){
   
    const buttonGroup = document.getElementById("button-group");
const result = document.getElementById("ticket_id");

const buttonGroupPressed = e => { 
  
  const isButton = e.target.nodeName === 'SEATS';
  
  if(!isButton) {
    return
  }
  if(clickCiunt <=1){
    result.innerHTML = `ID of <em>${e.target.innerHTML}</em> is <strong>${e.target.id}</strong>`;
    clickCiunt=2;
  }else{
    result.innerHTML = "";
    clickCiunt = 0;
  } 
}
    buttonGroup.addEventListener("click", buttonGroupPressed);
    
}

// Fetcher et sæde's ID når man klikker på det.
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

