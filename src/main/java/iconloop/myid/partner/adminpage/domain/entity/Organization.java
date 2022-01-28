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
    @Column(length = 10)
    private Long orgId;

    @Column(length = 50)
    private String orgName;
    @Column(length = 50)
    private String orgNameEng;
    @Column(length = 1)
    private char orgStatus;
    @Column(length = 1)
    private char isIssuer;
    @Column(length = 1)
    private char isVerifier;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime updated;

    @Builder
    public Organization(Long orgId, String orgName, String orgNameEng, char orgStatus, char isIssuer, char isVerifier, LocalDateTime created){
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgNameEng = orgNameEng;
        this.orgStatus = orgStatus;
        this.isIssuer = isIssuer;
        this.isVerifier = isVerifier;
        this.created = created;
    }
}
