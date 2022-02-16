package iconloop.myid.partner.adminpage.domain.repository;

import iconloop.myid.partner.adminpage.domain.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
