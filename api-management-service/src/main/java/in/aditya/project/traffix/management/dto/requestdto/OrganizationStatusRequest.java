package in.aditya.project.traffix.management.dto.requestdto;

import in.aditya.project.traffix.management.entity.OrganizationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrganizationStatusRequest {

    @NotNull
    private  OrganizationStatus status;
}
