package deors.demos.web.bootjpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface HotelRepository extends Repository<Hotel, Long> {

    Hotel findByCityAndName(String city, String name);

    @Query("select new deors.demos.web.bootjpa.ReviewSummary(h.city, h.name, avg(r.rating)) "
            + "from Hotel h left outer join h.reviews r where h.city = ?1 group by h")
    Page<Hotel> findByCity(String city, Pageable pageable);

}
