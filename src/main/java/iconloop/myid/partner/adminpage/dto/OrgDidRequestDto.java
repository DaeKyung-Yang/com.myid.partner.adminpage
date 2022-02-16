package iconloop.myid.partner.adminpage.dto;

import iconloop.myid.partner.adminpage.domain.entity.OrgDid;
import iconloop.myid.partner.adminpage.domain.entity.Organization;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrgDidRequestDto {

    private String did;
    private int nid;
    private String didPrivateKey;
    private char didStatus;
    private String description;
    private String didName;
    private LocalDateTime created;
    private Integer orgId;

    public OrgDid toEntity(){
        OrgDid build = OrgDid.builder()
                .did(did)
                .nid(nid)
                .didPrivateKey(didPrivateKey)
                .didStatus(didStatus)
                .description(description)
                .didName(didName)
                .organization(Organization.builder().orgId(orgId).build())
                .created(created)
                .build();
        return build;
    }

    @Builder
    public OrgDidRequestDto(String did, int nid, String didPrivateKey, char didStatus, String description, String didName, Integer orgId, LocalDateTime created){
        this.did = did;
        this.nid = nid;
        this.didPrivateKey = didPrivateKey;
        this.didStatus = didStatus;
        this.description = description;
        this.didName = didName;
        this.orgId = orgId;
        this.created = created;
    }

}
