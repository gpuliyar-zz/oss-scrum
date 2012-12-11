package oss.process.scrum.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oss.process.scrum.dao.model.IDao;
import oss.process.scrum.dao.vo.ScrOrganization;
import oss.process.scrum.domain.Organization;
import oss.process.scrum.exception.AppException;

@Service(value = "organizationService")
@Transactional
public class OrganizationService implements IOrganizationService {
    @Resource(name = "scrOrganizationDao")
    private IDao<ScrOrganization, String> organizationDao;

    @Override
    public void create(Organization data) throws AppException {
        ScrOrganization scrOrganization = new ScrOrganization();
        scrOrganization.setUuid(data.getId());
        scrOrganization.setName(data.getName());
        scrOrganization.setShortCode(data.getCode());
        scrOrganization.setDesc(data.getDescription());
        scrOrganization.setStatus(ScrOrganization.Status.valueOf(data.getStatus()));
        organizationDao.persist(scrOrganization);
    }

    @Override
    public void update(Organization data) throws AppException {
    }

    @Override
    public void delete(Organization data) throws AppException {
    }

    @Override
    public Organization retrieve(String id) throws AppException {
        return null;
    }

    @Override
    public List<Organization> retrieveAll(Organization data) throws AppException {
        return null;
    }
}
