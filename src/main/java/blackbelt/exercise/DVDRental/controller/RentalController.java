package blackbelt.exercise.DVDRental.controller;

import blackbelt.exercise.DVDRental.model.Rental;
import blackbelt.exercise.DVDRental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

/**
 * Receives https requests related to rentals and sends the request to the rental service.
 */
@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    /**
     * Calls the proper service to retrieve information about the requested rental.
     * @param id unique identifier for the rental
     * @return html format code with some information about the rental.
     */
    @GetMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getById(@PathVariable Long id) {
        try {
            Rental rental = rentalService.getRentalById(id);
            return "<html>\n" + "<header><title>Rental bill</title></header>\n" +
                    "<body>\n" +
                        "Movie: " + rental.getMovie().getTitle() + "<br>" +
                        "Rental duration: " + rental.getDaysRented() + " day(s)" + "<br>" +
                        "Amount: " + rental.calculateAmount() +
                    "</body>\n" + "</html>";

        } catch (NoSuchElementException ex) {
            return "<html>\n" + "<header><title>Rental bill</title></header>\n" +
                    "<body>\n" +
                        "There aren't any rental with id: " + id +
                    "</body>\n" + "</html>";

        }
    }
}
