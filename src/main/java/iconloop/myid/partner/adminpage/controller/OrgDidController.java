package iconloop.myid.partner.adminpage.controller;

import iconloop.myid.partner.adminpage.dto.OrgDidRequestDto;
import iconloop.myid.partner.adminpage.dto.OrgDidResponseDto;
import iconloop.myid.partner.adminpage.service.OrgDidService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/org-dids")
public class OrgDidController {
    private OrgDidService orgDidService;

    public OrgDidController(OrgDidService orgDidService){
        this.orgDidService = orgDidService;
    }

    @GetMapping
    public String list(Model model){
        List<OrgDidResponseDto> orgDidResponseDtoList = orgDidService.getOrgDidList();
        model.addAttribute("postList", orgDidResponseDtoList);
        return "admin/orgDidAdmin/list.html";
    }

    @GetMapping("/post")
    public String post(){
        return "admin/orgDidAdmin/post.html";
    }

    @PostMapping("/post")
    public String write(OrgDidRequestDto orgDidRequestDto){
        orgDidService.savePost(orgDidRequestDto);
        return "redirect:/org-dids";
    }

    @GetMapping("/post/edit/{did}")
    public String edit(@PathVariable("did") String did, Model model){
        OrgDidResponseDto orgDidResponseDto = orgDidService.getPost(did);
        model.addAttribute("post", orgDidResponseDto);
        return "admin/orgDidAdmin/edit.html";
    }

    @GetMapping("/{did}")
    public String detail(@PathVariable("did") String did, Model model){
        OrgDidResponseDto orgDidResponseDto = orgDidService.getPost(did);
        model.addAttribute("post", orgDidResponseDto);

        return "admin/orgDidAdmin/detail.html";
    }

    @PatchMapping("/post/edit/{did}")
    public String update(OrgDidRequestDto orgDidRequestDto){
        orgDidService.savePost(orgDidRequestDto);
        return "redirect:/org-dids";
    }

    @PostMapping("/delete")
    public String delete(String did){
        orgDidService.deletePost(did);
        return "redirect:/org-dids";
    }
}