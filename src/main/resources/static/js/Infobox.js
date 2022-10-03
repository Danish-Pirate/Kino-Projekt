var price2 = {
    pri: "100"
};

function addData(){

    class movieShow{

        endPointUrl = "http://";

        constructor(data){
            this.data = data;
        }

        async fetchData() {

            let response = await fetch(this.endPointUrl);

            if(response.status == 200){
                this.data = await response.json();
                

            }
            
        }




    }


var cinemaName = "Biograf: "+ "Bio1";
var movieName = "Filmnavn: " + "Dødets gab";
var date = "Dato: " + "22/10/2022";
var startTime = "Tidspunkt: " + "14:00"
var ageRestriction = "Minimums alder: " + "13";
var price = "Pris: " + "100" + "dkr.";


    document.getElementById('cinema_name_infobox_id').textContent = cinemaName;

    document.getElementById('movie_name_infobox_id').textContent = movieName;

    document.getElementById('date_infobox_id').textContent = date;

    document.getElementById('start_time_infobox_id').textContent = startTime;

    document.getElementById('age_infobox_id').textContent = ageRestriction;

    document.getElementById('price_infobox_id').textContent = "Pris: "+ price2.pri + " dkk";

}
