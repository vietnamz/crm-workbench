package com.advantco.crmworkbench.web;

import com.advantco.crmworkbench.business.domain.RoomReservation;
import com.advantco.crmworkbench.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class RoomReservationServiceController {

    private final ReservationService reservationService;

    @Autowired
    public RoomReservationServiceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservationForDate(@RequestParam(name = "date", required = false) String dateString) {
        Date date = DateUtil.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationForDate(date);
    }
}
