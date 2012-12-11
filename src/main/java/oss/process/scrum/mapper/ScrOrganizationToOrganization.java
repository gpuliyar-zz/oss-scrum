package oss.process.scrum.mapper;

import org.springframework.stereotype.Component;

import oss.process.scrum.dao.vo.ScrOrganization;
import oss.process.scrum.domain.Organization;

@Component(value = "scrOrganizationToOrganizationMapper")
public class ScrOrganizationToOrganization implements IMapper<ScrOrganization, Organization> {

    @Override
    public Organization map(ScrOrganization y) {
        Organization organization = new Organization();
        organization.setId(y.getUuid());
        organization.setCode(y.getShortCode());
        organization.setDescription(y.getDesc());
        organization.setName(y.getName());
        organization.setStatus(y.getStatus().toString());
        return organization;
    }
}
