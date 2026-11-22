package in.aditya.project.traffix.management.service;


import in.aditya.project.traffix.management.entity.Organization;
import in.aditya.project.traffix.management.entity.OrganizationStatus;
import in.aditya.project.traffix.management.exception.ApiException;
import in.aditya.project.traffix.management.repository.OrganizationRepository;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;


// when a logged in user wants to change the tanent name not slug


@Component
public class TenantContext {

    private final OrganizationRepository organizationRepository;

    public TenantContext(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization getOrganization() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof JwtAuthenticationToken)) {
            throw new ApiException(HttpStatus.FORBIDDEN, "Tenant identity is missing");
        }

        Long organizationId = ((JwtAuthenticationToken) authentication).getToken()
                .getClaim("organizationId");

        if(organizationId == null) {
            throw new ApiException(HttpStatus.FORBIDDEN, "Tenant identity is missing");
        }

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ApiException(HttpStatus.FORBIDDEN, "Organization does not exist"));

        if(organization.getStatus() != OrganizationStatus.ACTIVE) {
            throw new ApiException(HttpStatus.FORBIDDEN, "The organization is not active");
        }

        return organization;
    }
}