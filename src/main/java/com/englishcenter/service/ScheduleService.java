package com.englishcenter.service;
import java.util.List;
import com.englishcenter.dto.LichHocDTO;

public interface ScheduleService {
    List<LichHocDTO> getScheduleForCurrentUser();
}
