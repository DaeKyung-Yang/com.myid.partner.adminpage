package iconloop.myid.partner.adminpage.domain.entity;


import jdk.jfr.Unsigned;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrgDid {

    @Id @GeneratedValue @NotNull
    @Column(length = 100)
    private String did;
    @NotNull
    @Column(length = 11)
    private Long nid;
    @Column(length = 100)
    private String didPrivateKey;
    @Column(length = 1)
    private char didStatus;
    @Column(length = 250)
    private String description;
    @Column(length = 60)
    private String didName;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created;
    


}
