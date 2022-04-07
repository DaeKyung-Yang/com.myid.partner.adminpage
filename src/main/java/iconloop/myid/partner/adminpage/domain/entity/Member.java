package iconloop.myid.partner.adminpage.domain.entity;

import jdk.jfr.Unsigned;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id @GeneratedValue
    private Integer id;

    @Column(name = "user_id")
    private String memberId;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_name")
    private String name;

    @Builder
    public Member(Integer id, String memberId, String password, String name, String email){
        this.id = id;
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

}
