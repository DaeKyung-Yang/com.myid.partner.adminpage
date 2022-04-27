package iconloop.myid.partner.adminpage.controller;

import iconloop.myid.partner.adminpage.domain.entity.Notice;
import iconloop.myid.partner.adminpage.dto.NoticeDto;
import iconloop.myid.partner.adminpage.service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notices")
public class NoticeController {

    private NoticeService noticeService;

    public NoticeController(NoticeService noticeService){
        this.noticeService = noticeService;
    }

    @GetMapping
    public String list(@PageableDefault Pageable pageable, Model model){
        Page<Notice> noticeList = noticeService.getNoticeList(pageable);
        model.addAttribute("postList", noticeList);
        return "admin/notice/list.html";
    }

    @GetMapping("/post")
    public String post() {
        return "admin/notice/post.html";
    }

    @PostMapping("/post")
    public String write(NoticeDto noticeDto) {
        noticeService.savePost(noticeDto);
        return "redirect:/notices";
    }

    @GetMapping("/{id}")
        public String detail(@PathVariable("id") Integer id, Model model){
        NoticeDto noticeDto = noticeService.getNoticeById(id);
        model.addAttribute("post", noticeDto);

        return "admin/notice/detail.html";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        NoticeDto noticeDto = noticeService.getNoticeById(id);
        model.addAttribute("post", noticeDto);
        return "admin/notice/edit.html";
    }

    @PatchMapping("/post/edit/{id}")
    public String update(NoticeDto noticeDto){
        noticeService.savePost(noticeDto);
        return "redirect:/notices";
    }

    @PostMapping("/delete")
    public String delete(Integer id){
        noticeService.deleteNotice(id);
        return "redirect:/notices";
    }

}
