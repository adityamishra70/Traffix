package in.aditya.project.traffix.management.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class HealthResponse {

    private String serviceStatus;
    private String dbStatus;
    private LocalDateTime timeStamp;
}
