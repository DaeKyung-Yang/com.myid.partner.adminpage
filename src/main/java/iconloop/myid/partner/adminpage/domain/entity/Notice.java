package iconloop.myid.partner.adminpage.domain.entity;

import com.sun.istack.NotNull;
import jdk.jfr.Unsigned;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_notice")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Notice {

    @Id @GeneratedValue @NotNull
    @Unsigned
    @Column(name = "notice_id", length = 11)
    private Integer id;

    @NotNull
    @Column(name = "notice_title", length = 200)
    private String title;

    @Column(name = "notice_content")
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created;

    @Builder
    public Notice(Integer id, String title, String content, LocalDateTime created){
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
    }
}
