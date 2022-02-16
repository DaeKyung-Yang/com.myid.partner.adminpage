package iconloop.myid.partner.adminpage.controller;

import iconloop.myid.partner.adminpage.dto.OrganizationDto;
import iconloop.myid.partner.adminpage.service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/organizations")
public class OrganizationController {
    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    @GetMapping
    public String list(Model model) {
        List<OrganizationDto> organizationDtoList = organizationService.getOrganizationList();
        model.addAttribute("postList", organizationDtoList);
        return "admin/organizationAdmin/list.html";
    }

    @GetMapping("/post")
    public String post() {
        return "admin/organizationAdmin/post.html";
    }

    @PostMapping("/post")
    public String write(OrganizationDto organizationDto){
        organizationService.savePost(organizationDto);
        return "redirect:/organizations";
    }

    @GetMapping("/post/edit/{orgId}")
    public String edit(@PathVariable("orgId") Integer orgId, Model model){
        OrganizationDto organizationDto = organizationService.getPost(orgId);
        model.addAttribute("post", organizationDto);
        return "admin/organizationAdmin/edit.html";
    }

    @PatchMapping("/post/edit/{orgId}")
    public String update(OrganizationDto organizationDto){
        organizationService.savePost(organizationDto);
        return "redirect:/organizations";
    }

    @GetMapping("/post/delete")
    public String delete(@RequestParam("orgId") Integer orgId){
        organizationService.deletePost(orgId);
        return "redirect:/organizations";
    }
}
