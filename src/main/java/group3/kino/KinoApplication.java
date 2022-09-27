package group3.kino;

import group3.kino.bookingManager.model.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;
import java.security.PrivateKey;

@SpringBootApplication
public class KinoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinoApplication.class, args);

        /*Calculator calculator = new Calculator();

        System.out.println(calculator.totalPrice(100,2,2,2,2));*/
    }



}
