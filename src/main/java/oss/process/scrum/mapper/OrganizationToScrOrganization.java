package oss.process.scrum.mapper;

import org.springframework.stereotype.Component;

import oss.process.scrum.dao.vo.ScrOrganization;
import oss.process.scrum.domain.Organization;

@Component(value = "organizationToScrOrganizationMapper")
public class OrganizationToScrOrganization implements IMapper<Organization, ScrOrganization> {

    @Override
    public ScrOrganization map(Organization x) {
        ScrOrganization scrOrganization = new ScrOrganization();
        scrOrganization.setDesc(x.getDescription());
        scrOrganization.setName(x.getName());
        scrOrganization.setShortCode(x.getCode());
        scrOrganization.setStatus(ScrOrganization.Status.valueOf(x.getStatus()));
        scrOrganization.setUuid(x.getId());
        return scrOrganization;
    }
}
