package iconloop.myid.partner.adminpage.dto;

import iconloop.myid.partner.adminpage.domain.entity.Member;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {

    private Integer id;
    private String memberId;
    private String password;
    private String name;
    private String email;

    public Member toEntity(){
        Member build = Member.builder()
                .id(id)
                .memberId(memberId)
                .password(password)
                .name(name)
                .email(email)
                .build();
        return build;
    }

    @Builder
    public MemberDto(Integer id, String memberId, String password, String name, String email){
        this.id = id;
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
