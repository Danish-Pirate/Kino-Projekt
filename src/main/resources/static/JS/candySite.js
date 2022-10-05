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
    $("#modal-candy").submit(function (event) {
        let formData = {
            candyName: $("#candyName").val(),
            candySize: $("#candySize").val(),
            candyAmount: $("#candyAmount").val(),
            candyPrice: $("#candyPrice").val(),
            productLink: $("#productLink").val(),

        };

        $.ajax({
            type: "POST",
            url: "/addCandy",
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

async function deleteCandy(candyId) {
    await fetch('/deleteCandy/' + candyId, {
        method: 'DELETE'
    })
    refreshPage();
}

function refreshPage(){
    window.location.reload();
}


function updateCandy(id) {
    console.log(id);
}

//Pop up

function gallModal(element) {
    document.getElementById("modal-candy").src = element.src;
}






class CandyRenderer {

    endpointUrlCandy = "/getAllCandy";

    constructor() {
        this.dataCandy = null;
        this.fetchDataFromCandy();
    }

    //Fetch data from Film
    async fetchDataFromCandy() {
        let responseCandy = await fetch(this.endpointUrlCandy);
        this.dataCandy = await responseCandy.json();
        console.log(this.dataCandy);
        this.updateUI();
    }

    updateUI() {
        //Loops over all Film entries
        for (let dataCandyIndex in this.dataCandy) {

            var entryCandy = this.dataCandy[dataCandyIndex];

            //sets target for JS
            let target = $("#candy-cards");

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
                              <img src="${entryCandy.productLink}" alt="Candy poster" class="film-poster-img">
                          </div>
                          <div class="col-9 p-5">
                              <div class="row d-flex justify-content-space">
                                  <div class="col-4">
                                      <h4>Navn: </h4>
                                      <p>${entryCandy.candyName}</p>
                                  </div>
                                  <div class="col-4">
                                      <h4>Pris: </h4>
                                      <p>${entryCandy.candyPrice} kr.</p>
                                  </div>
                                  <div class="col-4">      
                                  <h4>Mængde: </h4>
                                  <p>${entryCandy.candyAmount}</p>
                                  </div>
                              </div>
                              <div class="row d-flex justify-content-space">
                                <div class="col-4">
                                    <h4>Størrelse: </h4>
                                    <p>${entryCandy.candySize}</p>
                                    </div>
                                <div class="col-4">
                                <button class="btn btn-primary" onclick="updateCandy(${entryCandy.candyId})">Rediger</button>
                            </div>
                            <div class="col-4">
                                <button id="candy-delete-btn" class="btn btn-primary" onclick="deleteCandy( ${entryCandy.candyId} )">Slet</button>
                            </div>
                          </div>
                      </div>
                      </div>
                      <div class="row">`;


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

var candyRenderer = new CandyRenderer();
