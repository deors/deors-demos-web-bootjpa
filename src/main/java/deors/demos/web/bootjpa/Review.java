package deors.demos.web.bootjpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Hotel hotel;

    @Column(nullable = false, name = "idx")
    private int index;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Rating rating;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date checkInDate;

    @Column(nullable = false, length = 5000)
    private String details;

    public Review(Hotel hotel, int index, Rating rating, Date checkInDate, String details) {

        super();
        this.hotel = hotel;
        this.index = index;
        this.rating = rating;
        this.checkInDate = checkInDate;
        this.details = details;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Hotel getHotel() {

        return hotel;
    }

    public void setHotel(Hotel hotel) {

        this.hotel = hotel;
    }

    public int getIndex() {

        return index;
    }

    public void setIndex(int index) {

        this.index = index;
    }

    public Rating getRating() {

        return rating;
    }

    public void setRating(Rating rating) {

        this.rating = rating;
    }

    public Date getCheckInDate() {

        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {

        this.checkInDate = checkInDate;
    }

    public String getDetails() {

        return details;
    }

    public void setDetails(String details) {

        this.details = details;
    }
}
