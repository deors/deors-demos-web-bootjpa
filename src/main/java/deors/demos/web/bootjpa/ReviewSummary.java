package deors.demos.web.bootjpa;

public class ReviewSummary {

    private final String city;

    private final String name;

    private final Double averageRating;

    public ReviewSummary(String city, String name, Double averageRating) {

        super();
        this.city = city;
        this.name = name;
        this.averageRating = averageRating;
    }

    public String getCity() {

        return city;
    }

    public String getName() {

        return name;
    }

    public Double getAverageRating() {

        return averageRating;
    }
}
