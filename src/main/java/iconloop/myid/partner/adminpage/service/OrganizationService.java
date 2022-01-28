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
    public Long savePost(OrganizationDto organizationDto){
        return organizationRepository.save(organizationDto.toEntity()).getOrgId();
    }

    @Transactional
    public List<OrganizationDto> getOrganizationList(){
        List<Organization> organizationsList = organizationRepository.findAll();
        List<OrganizationDto> organizationDtoList = new ArrayList<>();

        for(Organization organization : organizationsList){
            OrganizationDto organizationDto = OrganizationDto.builder()
                    .orgId(organization.getOrgId())
                    .orgName(organization.getOrgName())
                    .orgNameEng(organization.getOrgNameEng())
                    .orgStatus(organization.getOrgStatus())
                    .isIssuer(organization.getIsIssuer())
                    .isVerifier(organization.getIsVerifier())
                    .created(organization.getCreated())
                    .updated(organization.getUpdated())
                    .build();
            organizationDtoList.add(organizationDto);
        }
        return organizationDtoList;
    }

    @Transactional
    public OrganizationDto getPost(Long orgId){
        Organization organization = organizationRepository.findById(orgId).get();

        OrganizationDto organizationDto = OrganizationDto.builder()
                .orgId(organization.getOrgId())
                .orgName(organization.getOrgName())
                .orgNameEng(organization.getOrgNameEng())
                .orgStatus(organization.getOrgStatus())
                .isIssuer(organization.getIsIssuer())
                .isVerifier(organization.getIsVerifier())
                .created(organization.getCreated())
                .updated(organization.getUpdated())
                .build();
        return organizationDto;
    }

    @Transactional
    public void deletePost(Long orgId){
        organizationRepository.deleteById(orgId);
    }
}
