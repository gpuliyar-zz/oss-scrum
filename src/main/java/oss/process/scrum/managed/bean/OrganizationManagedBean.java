package oss.process.scrum.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import oss.process.scrum.domain.Organization;
import oss.process.scrum.exception.AppException;
import oss.process.scrum.service.IOrganizationService;

@ManagedBean(name = "organizationManagedBean")
@RequestScoped
public class OrganizationManagedBean implements Serializable {
    private static final long serialVersionUID = 7739087584554721913L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    @ManagedProperty(value = "#{organizationService}")
    private IOrganizationService organizationService;
    /**
     * @return the organizationService
     */
    public IOrganizationService getOrganizationService() {
        return organizationService;
    }

    /**
     * @param organizationService the organizationService to set
     */
    public void setOrganizationService(IOrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    private Organization organization;

    @PostConstruct
    public void initalize() {
        organization = new Organization();
    }

    /**
     * @return the organization
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String createOrganization() {
        try {
            organizationService.create(getOrganization());
        } catch (AppException e) {
            return ERROR;
        }

        return SUCCESS;
    }

    public String updateOrganization() {
        try {
            organizationService.update(getOrganization());
        } catch (AppException e) {
            return ERROR;
        }

        return SUCCESS;
    }

    public List<Organization> getOrganizations() {
        try {
            return organizationService.retrieveAll();
        } catch (AppException e) {
            return null;
        }
    }

    public void reset() {
        organization.setAction(null);
        organization.setCode(null);
        organization.setDescription(null);
        organization.setId(null);
        organization.setName(null);
        organization.setStatus(null);
    }
}
