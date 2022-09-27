package group3.kino.bookingManager.model;

public class Calculator {

    private double moviePrice;
    private int child;
    private int teenager;
    private int adult;
    private int pensioner;



    private double childSeats(double moviePrice, int children){
        double totalAmount = (moviePrice*children) /2;
        return totalAmount;

    }

    private double teenSeats(double moviePrice, int teens){
        double totalAmount = moviePrice*teens;
        double discount = (totalAmount) * 0.25;
        return totalAmount - discount ;
    }

    private double adultSeats(double moviePrice, int adults) {
        double totalAmount = (moviePrice * adult);
        return totalAmount;

    }

    private double pensionerSeats(double moviePrice, int pensioner) {
        double totalAmount = (moviePrice * pensioner) /2;
        return totalAmount;
    }


    public double totalPrice(double moviePrice, int child, int teenager, int adult, int pensioner){
        double childrenTotal = childSeats(moviePrice, child);
        double teenTotal = teenSeats(moviePrice, teenager);
        double adultTotal = adultSeats(moviePrice, adult);
        double pensionerTotal = pensionerSeats(moviePrice, pensioner);
        return childrenTotal + teenTotal + adultTotal + pensionerTotal;
    }


}
