const bookingCardTemplate = document.querySelector("[data-booking-template]")
const bookingCardContainer =document.querySelector("[data-booking-cards-container]")

class BookingRenderer{
endPointUrlBookings = "/json/bookings.json";

constructor(){
    this.dataBookings = null;
    this.fetchBookings();
}

async fetchBookings(){
let bookings = await fetch(this.endPointUrlBookings).then(res => res.json()).then(data =>{
    data.forEach(booking => {
        const card = bookingCardTemplate.content.cloneNode(true).children[0]
        const header = card.querySelector("[data-header]")
        const body = card.querySelector("[data-body]")
        header.textContent = booking.costumerName
        body.textContent = booking.phoneNumber
        bookingCardContainer.append(card)
    })
})
}
}