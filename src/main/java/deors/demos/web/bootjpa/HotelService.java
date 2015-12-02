package deors.demos.web.bootjpa;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HotelService {

    Hotel getHotel(String city, String name);

    Page<Hotel> getHotels(String city, Pageable pageable);

    Page<Review> getReviews(Hotel hotel, Pageable pageable);

    Review getReview(Hotel hotel, int index);

    Review addReview(Hotel hotel, Rating rating, Date checkInDate, String details);
}
