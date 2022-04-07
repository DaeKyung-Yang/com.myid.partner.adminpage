package iconloop.myid.partner.adminpage.controller;

import iconloop.myid.partner.adminpage.dto.MemberDto;
import iconloop.myid.partner.adminpage.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String index(){
        return "/home/index";
    }

    @GetMapping("/member/signup")
    public String signupForm(Model model){
        model.addAttribute("member", new MemberDto());
        return "/member/signupForm";
    }

    @PostMapping("/member/signup")
    public String signup(MemberDto memberDto){
        memberService.saveMember(memberDto);
        return "redirect:/";
    }

    @GetMapping("/member/login")
    public String login(){
        return "/member/loginForm";
    }
}
