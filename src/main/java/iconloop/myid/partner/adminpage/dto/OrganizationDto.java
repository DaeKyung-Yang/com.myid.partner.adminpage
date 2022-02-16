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
    private char orgStatus;
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

    @Builder
    public OrganizationDto(Integer orgId, String orgName, String orgNameEng, char orgStatus, char isIssuer, char isVerifier, LocalDateTime created, LocalDateTime updated) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgNameEng = orgNameEng;
        this.orgStatus = orgStatus;
        this.isIssuer = isIssuer;
        this.isVerifier = isVerifier;
        this.created = created;
        this.updated = updated;
    }
}
