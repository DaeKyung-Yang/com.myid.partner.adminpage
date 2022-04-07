package iconloop.myid.partner.adminpage.dto;

import iconloop.myid.partner.adminpage.domain.entity.Organization;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrganizationDto {

    private Integer orgId;
    private String orgName;
    private String orgNameEng;
    private String orgStatus;
    private char isIssuer;
    private char isVerifier;

    private LocalDateTime created;
    private LocalDateTime updated;

    public Organization toEntity() {
        Organization build = Organization.builder()
                .orgId(orgId)
                .orgName(orgName)
                .orgNameEng(orgNameEng)
                .orgStatus(orgStatus)
                .isIssuer(isIssuer)
                .isVerifier(isVerifier)
                .created(created)
                .build();
        return build;
    }

    //생성자에 organization을 받아서 생성
    public OrganizationDto(Organization organization){
        this.orgId = organization.getOrgId();
        this.orgName = organization.getOrgName();
        this.orgNameEng = organization.getOrgNameEng();
        this.orgStatus = organization.getOrgStatus();
        this.isIssuer = organization.getIsIssuer();
        this.isVerifier = organization.getIsVerifier();
        this.created = organization.getCreated();
        this.updated = organization.getUpdated();
    }
}
