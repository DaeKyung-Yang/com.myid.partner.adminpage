package iconloop.myid.partner.adminpage.dto;

import iconloop.myid.partner.adminpage.domain.entity.OrgDid;
import iconloop.myid.partner.adminpage.domain.entity.Organization;
import iconloop.myid.partner.adminpage.domain.repository.OrganizationRepository;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrgDidDto {

    OrganizationRepository organizationRepository;

    private String did;
    private int nid;
    private String didPrivateKey;
    private char didStatus;
    private String description;
    private String didName;
    private LocalDateTime created;
    private Integer orgId;
    private Organization organization;

    public OrgDid toEntity(){
        OrgDid build = OrgDid.builder()
                .did(did)
                .nid(nid)
                .didPrivateKey(didPrivateKey)
                .didStatus(didStatus)
                .description(description)
                .didName(didName)
                .organization(organization)
                .created(created)
                .build();
        return build;
    }

    @Builder
    public OrgDidDto(String did, int nid, String didPrivateKey, char didStatus, String description, String didName, Organization organization, LocalDateTime created){
        this.did = did;
        this.nid = nid;
        this.didPrivateKey = didPrivateKey;
        this.didStatus = didStatus;
        this.description = description;
        this.didName = didName;
        this.organization = organization;
        this.created = created;
    }

}
