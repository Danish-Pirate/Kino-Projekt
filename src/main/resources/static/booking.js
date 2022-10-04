class BookingRenderer {

    endpointUrlBooking = "booking.json";

    constructor(){
        this.dataBooking = null;
        this.fetchDataFromBookings();
    }
    async fetchDataFromBookings(){
        let res = await fetch(this.endpointUrlBooking);
        this.dataBooking = await res;
        this.updateUI();
    }
    updateUI(){

        let target = $("#booking-cards");

        let startCard = `<div class="container">
        <div class="row">
            <table class="border border-solid">
              <tr>
                <th>Navn</th>
                <th>Telefonnr</th>
                <th>Dato</th>
                <th>Tidspunkt</th>
                <th>Sal</th>
                <th>Titel</th>
                <th>Total pris</th>
              </tr>`;

        let cards = "";

        let endCard = `</table>
        </div>
        </div>`;

        for (let dataBookingIndex in this.dataBooking){

            var entryBooking = this.dataBooking[dataBookingIndex];

            cards += `<div class="container">
            <div class="row">
                <table class="border border-solid"><tr>`;
            cards += `<td>${entryBooking.customerName}</td>`;
            cards += `<td>${entryBooking.phoneNumber}</td>`;
            cards += `<td>${entryBooking.date}</td>`;
            cards += `<td>${entryBooking.timeSlot}</td>`;
            cards += `<td>${entryBooking.cinemaName}</td>`;
            cards += `<td>${entryBooking.movieName}</td>`;
            cards += `<td>${entryBooking.totalPrice}</td>`;
            cards += "</div></tr>";
        }

        target.append(startCard);
        target.append(cards);
        target.append(endCard);
    }
}
var bookingRenderer = new BookingRenderer();