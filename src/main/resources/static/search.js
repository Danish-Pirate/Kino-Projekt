class Calendar {
    getBookingsByMovieNameAndDateURL = "http://localhost:8080/booking-search/bookings_by_movie_name_and_date?date=2021-02-22&name=Shrek 3";

    constructor() {
    }

    async getMoviesByShowingDate(showingDate) {
        let getMoviesByDateURL = "http://localhost:8080/booking-search/movies_by_showing_date?showingDate=" + showingDate;
        try {
            let res = await fetch(getMoviesByDateURL);
            return await res.json();
        } catch (error) {
            console.log(error);
        }
    }

    async renderMovieData(date) {
        let listOfMovies = await this.getMoviesByShowingDate(date);
        listOfMovies.forEach(movie => {
            console.log(movie);
        });
    }
}

var cal = new Calendar();