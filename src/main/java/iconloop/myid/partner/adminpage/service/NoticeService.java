package iconloop.myid.partner.adminpage.service;

import iconloop.myid.partner.adminpage.domain.entity.Notice;
import iconloop.myid.partner.adminpage.domain.repository.NoticeRepository;
import iconloop.myid.partner.adminpage.dto.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeService {

    private NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository){
        this.noticeRepository = noticeRepository;
    }

    @Transactional
    public Integer savePost(NoticeDto noticeDto){
        return noticeRepository.save(noticeDto.toEntity()).getId();
    }

    @Transactional
    public Page<Notice> getNoticeList(Pageable pageable){
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() -1);
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC,"id"));
        return noticeRepository.findAll(pageable);
    }

    @Transactional
    public NoticeDto getNoticeById(Integer id) {
        Notice notice = noticeRepository.findById(id).get();

        NoticeDto noticeDto = NoticeDto.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .created(notice.getCreated())
                .build();
        return noticeDto;
    }

    @Transactional
    public void deleteNotice(Integer id){
        noticeRepository.deleteById(id);
    }
}
