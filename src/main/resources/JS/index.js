
function showAccordion(){

    var acc = document.getElementsByClassName("accordion");
    var i;
    
    for (i = 0; i < acc.length; i++) {
      acc[i].addEventListener("click", function() {
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

    endpointUrlFilms = 'films.json';
    endpointUrlShows = "shows.json";

    constructor() {
        this.dataFilm = null;
        this.dataShow = null;
        this.fetchDataFromFilms();
        this.fetchDataFromShows();
    }

    async fetchDataFromFilms() {
        let responseFilms = await fetch(this.endpointUrlFilms);
        this.dataFilm = await responseFilms.json();
        console.log(this.dataFilm);
        this.updateUI();
    };

    async fetchDataFromShows() {
        let responseShows = await fetch(this.endpointUrlShows);
        this.dataShow = await responseShows.json();
        console.log(this.dataShow);
        this.updateUI();
    };

    updateUI() {
        for (let dataFilmIndex in this.dataFilm) {

            let entryFilm = this.dataFilm[dataFilmIndex];

            let target = $('#film-cards');
          
            let cards = `<div class="container my-3">
                <div class="row border border-solid bg-light">
                    <div class="col-3 p-0">
                        <img src="images/Scooby.jpg" alt="Film poster" class="film-poster-img">
                    </div>
                    <div class="col-9 p-5">
                        <div class="row d-flex justify-content-space">
                            <div class="col-4">
                                <h4>Titel: </h4>
                                <p>${entryFilm.title}</p>
                            </div>
                            <div class="col-4">
                                <h4>Pris: </h4>
                                <p>${entryFilm.price} kr.</p>
                            </div>
                            <div class="col-4">
                                        
                            <h4>Aldersgrænse: </h4>
                            <p>${entryFilm.ageLimit} år</p>
                            </div>
                        </div>
                        <div class="row">
                            <h4>Beskrivelse: </h4>
                            <p>${entryFilm.description}</p>
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
                        </tr>
                        <tr>
                            <div class="me-5">`;

        for (let dataShowIndex in this.dataShow) {

            let entryShow = this.dataShow[dataShowIndex];

            if(entryShow.movieName == entryFilm.title && entry)  {

            }

            cards += ``

        } 

        target.append(cards);

        }
    }
}

var filmRenderer = new FilmRenderer();

/*
                        <th>Mandag d. 26-09-2022</th></div>
                        <th><button>15:00</button> <button>18:30</button></th>

                    </tr>
                </table>
            </div>
        </div>

        */