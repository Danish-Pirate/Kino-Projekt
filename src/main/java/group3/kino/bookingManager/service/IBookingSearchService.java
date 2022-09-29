package group3.kino.bookingManager.service;

import group3.kino.bookingManager.model.Booking;

import java.util.List;

public interface IBookingSearchService {
        public List<Booking> findByPhoneNumber(String phoneNumber);
}
