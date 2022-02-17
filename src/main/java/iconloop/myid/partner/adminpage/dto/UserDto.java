package iconloop.myid.partner.adminpage.dto;

import iconloop.myid.partner.adminpage.domain.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String userId;
    private String password;
    private String name;
    private String email;

    public User toEntity(){
        User build = User.builder()
                .id(id)
                .userId(userId)
                .password(password)
                .name(name)
                .email(email)
                .build();
        return build;
    }

    @Builder
    public UserDto(Integer id, String userId, String password, String name, String email){
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
