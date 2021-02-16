package com.advantco.crmworkbench.web;


import com.advantco.crmworkbench.business.domain.RoomReservation;
import com.advantco.crmworkbench.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = DateUtil.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "reservations";
    }
}