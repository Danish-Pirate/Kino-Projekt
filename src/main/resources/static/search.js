class Calendar {
    getMoviesByDateURL = "http://localhost:8080/booking-search/movies_by_date?date=2021-02-22";
    getBookingsByMovieNameAndDateURL = "http://localhost:8080/booking-search/bookings_by_movie_name_and_date?date=2021-02-22&name=Shrek 3";

    constructor() {
        this.getMoviesByDate()
    }

    async getMoviesByDate(date) {
        //let data = await fetch(this.getMoviesByDateURL);
        let data = await fetch(this.getBookingsByMovieNameAndDateURL);
        console.log(data);
    }
}
var cal = new Calendar();