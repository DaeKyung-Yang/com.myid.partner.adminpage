package iconloop.myid.partner.adminpage.controller;

import iconloop.myid.partner.adminpage.dto.OrganizationDto;
import iconloop.myid.partner.adminpage.service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrganizationController {
    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<OrganizationDto> organizationDtoList = organizationService.getOrganizationList();
        model.addAttribute("postList", organizationDtoList);
        return "admin/list.html";
    }

    @GetMapping("/post")
    public String post() {
        return "admin/post.html";
    }

    @PostMapping("/post")
    public String write(OrganizationDto organizationDto){
        organizationService.savePost(organizationDto);
        return "redirect:/";
    }

    @GetMapping("/post/edit/{org_id}")
    public String edit(@PathVariable("org_id") Long org_id, Model model){
        OrganizationDto organizationDto = organizationService.getPost(org_id);
        model.addAttribute("post", organizationDto);
        return "admin/edit.html";
    }

    @PatchMapping("/post/edit/{org_id}")
    public String update(OrganizationDto organizationDto){
        organizationService.savePost(organizationDto);
        return "redirect:/";
    }

    @GetMapping("/post/delete")
    public String delete(@RequestParam("org_id") Long org_id){
        organizationService.deletePost(org_id);
        return "redirect:/";
    }
}
