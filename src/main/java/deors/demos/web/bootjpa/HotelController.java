package deors.demos.web.bootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hotels")
    public Page<Hotel> listHotels(@RequestParam(value = "city") String city, Pageable pageable) {

        return this.hotelService.getHotels(city, pageable);
    }

}
