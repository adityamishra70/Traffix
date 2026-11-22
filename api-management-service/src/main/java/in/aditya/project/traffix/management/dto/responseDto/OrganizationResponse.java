package in.aditya.project.traffix.management.dto.responseDto;

import in.aditya.project.traffix.management.entity.Organization;
import in.aditya.project.traffix.management.entity.OrganizationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class OrganizationResponse {

    private Long id;
    private String name;
    private String slug;
    private OrganizationStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static OrganizationResponse from(Organization organization) {
        return new OrganizationResponse(organization.getId(),
                organization.getName(),
                organization.getSlug(),
                organization.getStatus(),
                organization.getCreatedAt(),
                organization.getUpdatedAt());

    }
}
