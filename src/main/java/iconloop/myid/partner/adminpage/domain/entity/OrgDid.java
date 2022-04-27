package iconloop.myid.partner.adminpage.domain.entity;

import jdk.jfr.Unsigned;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_org_did")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrgDid implements Serializable {

    @Id @NotNull
    @Column(length = 100)
    private String did;
    @NotNull
    @Column(length = 11)
    private Integer nid;
    @Column(name = "did_private_key", length = 100)
    private String didPrivateKey;
    @Column(name = "did_status", length = 1)
    private String didStatus;
    @Column(length = 250)
    private String description;
    @Column(name = "did_name", length = 60)
    private String didName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", referencedColumnName = "org_id")
    private Organization organization;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created;

    @Builder
    public OrgDid(String did, Integer nid, String didPrivateKey, String didStatus, String description, String didName, Organization organization, LocalDateTime created){
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
