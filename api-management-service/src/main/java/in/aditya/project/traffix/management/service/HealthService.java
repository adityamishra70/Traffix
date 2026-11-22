package in.aditya.project.traffix.management.service;


import in.aditya.project.traffix.management.dto.responseDto.HealthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthService {

    //to check if db is reachable or not.
    public final JdbcTemplate jdbcTemplate;

    public String getHealth(){

        String dbStatus = "DOWN";

        try{
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);

            if(Integer.valueOf(1).equals(result)){
                dbStatus = "UP";
            }
        }
        catch (Exception e){
            System.out.println("DB cannot be accessed" + e.getMessage());
        }

        return dbStatus;
    }
}
