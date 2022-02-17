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
public class User {

    @Id @GeneratedValue @NotNull
    @Unsigned
    @Column
    private Integer id;

    @Column
    private String userId;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String email;

    @Builder
    public User(Integer id, String userId, String password, String name, String email){
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }


}
