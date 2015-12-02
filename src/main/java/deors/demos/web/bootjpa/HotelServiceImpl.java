package deors.demos.web.bootjpa;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final ReviewRepository reviewRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository, ReviewRepository reviewRepository) {

        this.hotelRepository = hotelRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Hotel getHotel(String city, String name) {

        Assert.notNull(city, "City must not be null");
        Assert.hasLength(name, "Name must not be empty");
        return this.hotelRepository.findByCityAndName(city, name);
    }

    @Override
    public Page<Hotel> getHotels(String city, Pageable pageable) {

        Assert.notNull(city, "City must not be null");
        return this.hotelRepository.findByCity(city, pageable);
    }

    @Override
    public Page<Review> getReviews(Hotel hotel, Pageable pageable) {

        Assert.notNull(hotel, "Hotel must not be null");
        return this.reviewRepository.findByHotel(hotel, pageable);
    }

    @Override
    public Review getReview(Hotel hotel, int reviewNumber) {

        Assert.notNull(hotel, "Hotel must not be null");
        return this.reviewRepository.findByHotelAndIndex(hotel, reviewNumber);
    }

    @Override
    public Review addReview(Hotel hotel, Rating rating, Date checkInDate, String details) {

        Review review = new Review(hotel, 1, rating, checkInDate, details);
        return reviewRepository.save(review);
    }

}
