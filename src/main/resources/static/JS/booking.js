class Booking {
    getBookingJson = "http://localhost:8080/booking-search";
    

    constructor() {
        this.getBookingJson()
    }

    async getBookingJson() {
        let data = await fetch(this.getBookingJson);
        console.log(data);
    }
}
var cal = new Booking();