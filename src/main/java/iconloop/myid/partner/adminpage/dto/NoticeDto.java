package iconloop.myid.partner.adminpage.dto;

import iconloop.myid.partner.adminpage.domain.entity.Notice;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeDto {

    private Integer id;
    private String title;
    private String content;
    private LocalDateTime created;

    public Notice toEntity(){
        Notice build = Notice.builder()
                .id(id)
                .title(title)
                .content(content)
                .created(created)
                .build();
        return build;
    }

    @Builder
    public NoticeDto(Integer id, String title, String content, LocalDateTime created){
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
    }
}
