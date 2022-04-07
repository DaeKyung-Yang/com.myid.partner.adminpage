package iconloop.myid.partner.adminpage.domain.entity;

import com.sun.istack.NotNull;
import jdk.jfr.Unsigned;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Organization {

    @Id @GeneratedValue @NotNull
    @Unsigned
    @Column(name = "org_id", length = 10)
    private Integer orgId;

    @Column(name = "org_name", length = 50)
    private String orgName;
    @Column(name = "org_name_eng", length = 50)
    private String orgNameEng;
    @Column(name = "org_status", length = 1)
    private String orgStatus;
    @Column(name = "is_issuer", length = 1)
    private char isIssuer;
    @Column(name = "is_verifier", length = 1)
    private char isVerifier;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime updated;

//    @OneToMany(mappedBy = "organization")
//    private List<OrgDid> OrgDids = new ArrayList<>();

    @Builder
    public Organization(Integer orgId, String orgName, String orgNameEng, String orgStatus, char isIssuer, char isVerifier, LocalDateTime created){
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgNameEng = orgNameEng;
        this.orgStatus = orgStatus;
        this.isIssuer = isIssuer;
        this.isVerifier = isVerifier;
        this.created = created;
    }
}
