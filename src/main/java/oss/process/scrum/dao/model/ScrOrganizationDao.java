package oss.process.scrum.dao.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oss.process.scrum.dao.vo.ScrOrganization;

@Repository(value = "scrOrganizationDao")
public class ScrOrganizationDao extends AbstractDao<ScrOrganization, String> implements IDao<ScrOrganization, String> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public ScrOrganizationDao() {
        this.setClazz(ScrOrganization.class);
    }
}
