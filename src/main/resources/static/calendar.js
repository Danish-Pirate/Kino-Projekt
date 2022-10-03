class Calendar {
    constructor() {
    }

    async getMoviesByShowingDate(showingDate) {
        let getMoviesByDateURL = "http://localhost:8080/booking-search/showing_date?showingDate=" + showingDate;
        try {
            let res = await fetch(getMoviesByDateURL);
            return await res.json();
        } catch (error) {
            console.log(error);
        }
    }

    async getMovieBookingStats(movieName, showingDate) {
        let bookingListURL = "http://localhost:8080/booking-search/showing_date/movie_name?date=" + "2022-02-20" + "&name=" + movieName;
        try {
            let res = await fetch(bookingListURL);
            return await res.json();
        } catch (error) {
            console.error(error);
        }
    }

    async renderMovieData(date) {
        let listOfMovies = await this.getMoviesByShowingDate(date);
        listOfMovies.forEach(async movie => {
            let listOfBookings = await this.getMovieBookingStats(movie.name, date);
            console.log(movie.name + " " + listOfBookings.length);
        });
    }
}

var cal = new Calendar();