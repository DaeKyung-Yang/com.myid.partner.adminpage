package iconloop.myid.partner.adminpage.dto;

import iconloop.myid.partner.adminpage.domain.entity.OrgDid;
import iconloop.myid.partner.adminpage.domain.entity.Organization;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrgDidResponseDto {

    private String did;
    private Integer nid;
    private String didPrivateKey;
    private String didStatus;
    private String description;
    private String didName;
    private LocalDateTime created;
    private Organization organization;

    public OrgDidResponseDto(OrgDid entity){
        this.did = entity.getDid();
        this.nid = entity.getNid();
        this.didPrivateKey = entity.getDidPrivateKey();
        this.didStatus = entity.getDidStatus();
        this.description = entity.getDescription();
        this.didName = entity.getDidName();
        this.created = entity.getCreated();
        this.organization = entity.getOrganization();
    }
}
