package iconloop.myid.partner.adminpage.service;

import iconloop.myid.partner.adminpage.domain.entity.OrgDid;
import iconloop.myid.partner.adminpage.domain.repository.OrgDidRepository;
import iconloop.myid.partner.adminpage.dto.OrgDidRequestDto;
import iconloop.myid.partner.adminpage.dto.OrgDidResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrgDidService {

    private OrgDidRepository orgDidRepository;

    public OrgDidService(OrgDidRepository orgDidRepository){
        this.orgDidRepository = orgDidRepository;
    }

    @Transactional
    public String savePost(OrgDidRequestDto orgDidRequestDto){
        return orgDidRepository.save(orgDidRequestDto.toEntity()).getDid();
    }

    @Transactional
    public List<OrgDidResponseDto> getOrgDidList(){
        List<OrgDid> orgDidsList = orgDidRepository.findAll();
        List<OrgDidResponseDto> orgDidResponseDtoList = new ArrayList<>();

        for(OrgDid orgDid : orgDidsList){
            orgDidResponseDtoList.add(new OrgDidResponseDto(orgDid));
        }
        return orgDidResponseDtoList;
    }

    @Transactional
    public OrgDidResponseDto getPost(String did){
        OrgDid orgDid = orgDidRepository.findById(did).get();
        return new OrgDidResponseDto(orgDid);
    }

    @Transactional
    public void deletePost(String did){
        orgDidRepository.deleteById(did);
    }
}
