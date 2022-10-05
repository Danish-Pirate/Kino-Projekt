//Sends data from form to endpoint /// Endpoint = /bookings (POST)
/*
$(document).ready(function () {
  $("#form-id").submit(function (event) {
      let formData = {
          title: $("#title").val(),
          price: $("#price").val(),
      };

      $.ajax({
          type: "POST",
          url: "/film",
          data: JSON.stringify(formData),
          dataType: "json",
          encode: true,
          headers:{"Content-Type":"application/json;charset=UTF-8"},
      }).done(function (data) {
          console.log(data);
      });

      event.preventDefault();
  });
});

*/

//Sends data from form to endpoint /// Endpoint = /bookings (POST)

$(document).ready(function () {
    $("#modal-film").submit(function (event) {
        let formData = {
            name: $("#name").val(),
            moviePrice: $("#moviePrice").val(),
            movieLength: $("#movieLength").val(),
            movieGenre: $("#movieGenre").val(),
            movieAgeRestriction: $("#movieAgeRestriction").val(),
            posterLink: $("#posterLink").val(),

        };

        $.ajax({
            type: "POST",
            url: "/addMovie",
            data: JSON.stringify(formData),
            dataType: "json",
            encode: true,
            headers:{"Content-Type":"application/json;charset=UTF-8"}
        }).done(function (data) {
            console.log(data);
        });
        event.preventDefault();
    });

});

async function deleteFilm(movieId) {
    await fetch('/deleteFilm/' + movieId, {
        method: 'DELETE'
    })
    refreshPage();
}

function refreshPage(){
    window.location.reload();
}


async function GetFilm(id) {

    let endpointGetFilmById = '/getMovie/' + id
    let responseFilm = await fetch(endpointGetFilmById);
    let dataFilmFromId = await responseFilm.json();

    let targetForEditFilm = $("#edit-film-card");

    let modalCardForEditFilm =
        `
        <h1>HELLO FROM JAVASCRIPT</h1>
        `;

    targetForEditFilm.append(modalCardForEditFilm);


    console.log(dataFilmFromId);
/*
    $.ajax({
        type: "PUT",
        url: "/editMovie",
        data: JSON.stringify(formData),
        dataType: "json",
        encode: true,
        headers:{"Content-Type":"application/json;charset=UTF-8"}
    }).done(function (data) {
        console.log(data);
    });
    event.preventDefault();
*/

}


async function UpdateFilm(){

}
//Pop up

function gallModal(element) {
    document.getElementById("modal-bookning").src = element.src;
}


//Accordion
function showAccordion() {
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function () {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.display === "block") {
                panel.style.display = "none";
            } else {
                panel.style.display = "block";
            }
        });
    }
}


class FilmRenderer {

    endpointUrlFilms = "/getAllMovie";

    constructor() {
        this.dataFilm = null;
        this.fetchDataFromFilms();
    }

    //Fetch data from Film
    async fetchDataFromFilms() {
        let responseFilms = await fetch(this.endpointUrlFilms);
        this.dataFilm = await responseFilms.json();
        this.updateUI();
    }

    updateUI() {
        //Loops over all Film entries
        for (let dataFilmIndex in this.dataFilm) {

            var entryFilm = this.dataFilm[dataFilmIndex];

            //sets target for JS
            let target = $("#film-cards");

            /***
             *

            KUN TAGET UD IMENS MAN IKKE KAN OPRETTE VISNINGER. MÅ IKKE SLETTES!

            //Array for show dates
            let dateList = new Array();

            //Populates show dates array, discards duplicate dates
            entryFilm.showList.forEach((showList) => {
                if (!dateList.includes(showList.date)) {
                    dateList.push(showList.date);
                }
            });

            //Sorts Array in ascending order by date
            let sortedDateList = dateList.sort((a, b) => {
                return new Date(a) - new Date(b)
            });

             */


            //First part of Film-Card
            var cards = `<div class="container my-3">
                      <div class="row border border-solid bg-light">
                          <div class="col-3 p-0">
                              <img src="${entryFilm.posterLink}" alt="Film poster" class="film-poster-img">
                          </div>
                          <div class="col-9 p-5">
                              <div class="row d-flex justify-content-space">
                                  <div class="col-4">
                                      <h4>Titel: </h4>
                                      <p>${entryFilm.name}</p>
                                  </div>
                                  <div class="col-4">
                                      <h4>Pris: </h4>
                                      <p>${entryFilm.moviePrice} kr.</p>
                                  </div>
                                  <div class="col-4">      
                                  <h4>Aldersgrænse: </h4>
                                  <p>${entryFilm.movieAgeRestriction} år</p>
                                  </div>
                              </div>
                              <div class="row d-flex justify-content-space">
                                <div class="col-4">
                                    <h4>Genre: </h4>
                                    <p>${entryFilm.movieGenre}</p>
                                    </div>
                                <div class="col-4">

                                <button class="btn btn-primary" onclick="GetFilm(${entryFilm.movieId})">Rediger</button>
                            </div>
                            <div class="col-4">
                                <button id="film-delete-btn" class="btn btn-primary" onclick="deleteFilm( ${entryFilm.movieId} )">Slet</button>
                            </div>
                          </div>
                      </div>
                      </div>
                      <div class="row">
                  <button class="accordion fw-bold" onclick="showAccordion()">Visninger</button>
                      <div class="panel">
                          <table class="d-flex justify-content-center">
                              <tr>
                                  <th>Dato</th>
                                  <th>Visninger</th>
                              </tr>`;


            /**
             * KUN TAGET UD IMENS MAN IKKE KAN OPRETTE VISNINGER. MÅ IKKE SLETTES!


            //Loop for adding show times to dates for each film
            for (let i = 0; i < sortedDateList.length; i++) {
                //Finds week day from date
                let dateForweekDate = new Date(sortedDateList[i]);
                const options = { weekday: 'long'};
                let weekDayDone = new Intl.DateTimeFormat('dk-DK', options).format(dateForweekDate);
                //Makes first letter upper case
                weekDayDone = weekDayDone.charAt(0).toUpperCase() + weekDayDone.slice(1);

                cards += `<tr><th>${weekDayDone} d. ${sortedDateList[i]}</th>`;

                //Sorts time
                let timeArray = new Array();
                entryFilm.showList.forEach((show) => {
                    if (sortedDateList[i] == show.date) {
                        timeArray.push(show.time);
                    }
                });

                timeArray = timeArray.sort();


                //Adds time under date, if dates are identical
                //x keeps track of timeArray index
                let x = 0;
                entryFilm.showList.forEach((showList) => {
                    if (sortedDateList[i] == showList.date) {
                        cards += `<th class="px-4"><button>${timeArray[x]}</button></th>`;
                        x += 1;
                    }

                });

                cards += "</tr>";

            }
             */

            //Closing HTML
            cards += `</table></div></div></div>`;
            //Adds film-cards to HTML
            target.append(cards);
        }
    }
}

var filmRenderer = new FilmRenderer();


