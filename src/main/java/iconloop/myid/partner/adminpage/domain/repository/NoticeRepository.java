package iconloop.myid.partner.adminpage.domain.repository;

import iconloop.myid.partner.adminpage.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
