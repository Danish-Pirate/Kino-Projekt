//global variables
let searchDate;
//const filmCardsHallOne = document.getElementById('film-schedule-cards-hall1');


$(document).ready( function() {
    //odays date in date format
    let now = new Date();

    //Making the date a string and making it in the format: YYYY-MM-DD
    let day = ("0" + now.getDate()).slice(-2);
    let month = ("0" + (now.getMonth() + 1)).slice(-2);
    let today = now.getFullYear()+"-"+(month)+"-"+(day) ;

    //Sends the new string date to html form
    $('#datePicker').val(today);
    searchDate = today;

    //Updates UI when clicking on the search button
    $('#selectNewDate').click( () =>{
        searchDate = document.getElementById("datePicker").value;
        console.log(searchDate);

        //Removes the old film cards
        $('#film-schedule-cards-hall1').html('');

        //Updates UI with new film cards
        filmsScheduleRenderer.updateUI();
    });


});


class FilmsScheduleRenderer {

    endpointUrlFilmsSchedule = "/json/films.json";



    constructor() {
        this.dataScheduleFilm = null;
        this.fetchDataFromFilms();
    }

    //Fetch data from Film
    async fetchDataFromFilms() {
        let responseFilms = await fetch(this.endpointUrlFilmsSchedule);
        this.dataScheduleFilm = await responseFilms.json();
        this.updateUI();
    }

    updateUI() {

        //sets standard date to todays date

        let filmsScheduleDate = searchDate;


        //Loops over all Film entries
        for (let dataScheduleFilmIndex in this.dataScheduleFilm) {

            //Resets card to append
            let cards = "";


            let entryFilmSchedule = this.dataScheduleFilm[dataScheduleFilmIndex];

            //sets target for JS
            var target = $("#film-schedule-cards-hall1");


            //Boolean for checking if film is already on the list
            let isAlreadyOnTheList = 0;


            for (let i = 0; i < entryFilmSchedule.showList.length; i++) {

                //confirms that the film has a show that is in hall 1 with the selected date
                if(
                    entryFilmSchedule.showList[i].cinemaHall.name == "Sal 1"
                    &&
                    entryFilmSchedule.showList[i].date == filmsScheduleDate
                    &&
                    isAlreadyOnTheList == 0
                ){

                    //Sets checker to 1 to indicate that the film is already on the list
                    isAlreadyOnTheList += 1;

                    //Building the start of the film cards
                    cards +=
                        `<div class="row bg-light border border-solid p-5 m-2">
                    <div class="col-6">
                        <h4>${entryFilmSchedule.name}</h4>
                        <img src="/images/Scooby.jpg" alt="Scooby-doo">
                    </div>
                    <div class="col-6">

                        <div>
                            <h4>Pris: </h4>
                            <p>${entryFilmSchedule.moviePrice} kr.</p>         
                            <h4>Aldersgrænse: </h4>
                            <p>${entryFilmSchedule.movieAgeRestriction} år</p>
                            <div class="py-5">`;
                }

                if(entryFilmSchedule.showList[i].cinemaHall.name == "Sal 1" && entryFilmSchedule.showList[i].date == filmsScheduleDate){
                    cards +=
                        `<button class="mb-2 mx-1">${entryFilmSchedule.showList[i].time}</button>`;
                }

            }
            //closing tags
            cards += `
                     </div>
                </div>               
            </div>
        </div>`;
            //Adds cards to html
            target.append(cards);
        }
    }
}

var filmsScheduleRenderer = new FilmsScheduleRenderer();
