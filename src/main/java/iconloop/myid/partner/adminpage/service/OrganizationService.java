package iconloop.myid.partner.adminpage.service;

import iconloop.myid.partner.adminpage.domain.repository.OrganizationRepository;
import iconloop.myid.partner.adminpage.dto.OrganizationDto;
import iconloop.myid.partner.adminpage.domain.entity.Organization;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    @Transactional
    public Integer savePost(OrganizationDto organizationDto){
        return organizationRepository.save(organizationDto.toEntity()).getOrgId();
    }

    @Transactional
    public List<OrganizationDto> getOrganizationList(){
        List<Organization> organizationsList = organizationRepository.findAll();
        List<OrganizationDto> organizationDtoList = new ArrayList<>();

        for(Organization organization : organizationsList){
            organizationDtoList.add(new OrganizationDto(organization));
        }
        return organizationDtoList;
    }

    @Transactional
    public OrganizationDto getPost(Integer orgId){
        Organization organization = organizationRepository.findById(orgId).get();
//        OrganizationDto organizationDto  = new OrganizationDto(organization);
        return new OrganizationDto(organization);
    }

    @Transactional
    public void deletePost(Integer orgId){
        organizationRepository.deleteById(orgId);
    }
}
