package com.englishcenter.service;
import org.springframework.stereotype.Service;
import java.util.*;
import com.englishcenter.dto.LichHocDTO;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public List<LichHocDTO> getScheduleForCurrentUser() {
        return List.of(
                new LichHocDTO(1, "English A1", "Thứ 2, 4, 6", "18:00", "19:30", "Phòng 302"),
                new LichHocDTO(2, "English A2", "Thứ 3, 5, 7", "19:30", "21:00", "Phòng 303")
        );
    }
}
