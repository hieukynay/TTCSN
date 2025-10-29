package com.englishcenter.controller;

import com.englishcenter.dto.LichHocDTO;
import com.englishcenter.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/me")
    public List<LichHocDTO> getMySchedule() {
        return scheduleService.getScheduleForCurrentUser();
    }
}
