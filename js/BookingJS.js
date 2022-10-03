const seatID = [];

function seatNumbering(){
    
    var seats = "";
    var seatNum = 1;
    var rowNum = 1;
    const seatNumberIDs = [];
    var gridcount = 1;
    var seat_id = 0;


for(let i = 0; i < 260; i++){
    
    
    if (gridcount == 1){
        seats = seats + '<seats class="row_class">' + "row: " + rowNum + '</seats>';
    }else{
        seat_id++;
        seats = seats + '<seats class="cinema_one_seat_class" id="seat_id_' + seat_id +'"  onclick="seatColorChange();tickets();">' +"sæde: " + seatNum+ '</seats>';
        seatID.push("seat_id_" + seat_id);
        if(seatNum==12){
            seatNum = 1
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
    seatIDs.addEventListener('click', getSeatIDFromClick,);
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

let message_count = 0;

function tickets(){

    const buttons = document.getElementsByTagName("seats");
    var result1 = document.getElementById('ticket_id');

const buttonPressed1 = message => {
    result1.innerHTML = `<strong>${message.target.id}</strong>`;
}

    if(message_count < 1){
        message_count += 1;
        for (let button of buttons) {
            button.addEventListener("click", buttonPressed1);
        }
    }
    else{
        message_count = 0;
        button.removeEventListener("click", buttonPressed1)
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
}
