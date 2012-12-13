package oss.process.scrum.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oss.process.scrum.dao.model.IDao;
import oss.process.scrum.dao.vo.ScrOrganization;
import oss.process.scrum.domain.Organization;
import oss.process.scrum.exception.AppException;
import oss.process.scrum.mapper.IMapper;

@Service(value = "organizationService")
@Transactional
public class OrganizationServiceImpl implements OrganizationService {
    @Resource(name = "scrOrganizationDao")
    private IDao<ScrOrganization, String> organizationDao;
    @Resource(name = "organizationToScrOrganizationMapper")
    private IMapper<Organization, ScrOrganization> orgToScrOrgMapper;
    @Resource(name = "scrOrganizationToOrganizationMapper")
    private IMapper<ScrOrganization, Organization> scrOrgToOrgMapper;

    @Override
    public void create(Organization data) throws AppException {
        ScrOrganization scrOrganization = orgToScrOrgMapper.map(data);
        organizationDao.persist(scrOrganization);
    }

    @Override
    public void update(Organization data) throws AppException {
        ScrOrganization scrOrganization = orgToScrOrgMapper.map(data);
        organizationDao.persist(scrOrganization);
    }

    @Override
    public void delete(Organization data) throws AppException {
        ScrOrganization scrOrganization = orgToScrOrgMapper.map(data);
        organizationDao.delete(scrOrganization);
    }

    @Override
    public Organization retrieveById(String id) throws AppException {
        ScrOrganization scrOrganization = organizationDao.findById(id);
        Organization organization = scrOrgToOrgMapper.map(scrOrganization);
        return organization;
    }

    @Override
    public List<Organization> retrieveByExample(Organization data) throws AppException {
        ScrOrganization scrOrganization = orgToScrOrgMapper.map(data);
        List<ScrOrganization> scrOrganizations = organizationDao.findByExample(scrOrganization);
        List<Organization> organizations = new ArrayList<Organization>();

        for (ScrOrganization scrOrganization2 : scrOrganizations) {
            organizations.add(scrOrgToOrgMapper.map(scrOrganization2));
        }

        return organizations;
    }

    @Override
    public List<Organization> retrieveAll() throws AppException {
        ScrOrganization scrOrganization = new ScrOrganization();
        List<ScrOrganization> scrOrganizations = organizationDao.findByExample(scrOrganization);
        List<Organization> organizations = new ArrayList<Organization>();

        for (ScrOrganization scrOrganization2 : scrOrganizations) {
            organizations.add(scrOrgToOrgMapper.map(scrOrganization2));
        }

        return organizations;
    }
}
