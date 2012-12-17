package oss.process.scrum.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

import oss.process.scrum.dao.vo.ScrOrganization;
import oss.process.scrum.domain.Organization;
import oss.process.scrum.domain.User;
import oss.process.scrum.exception.AppException;
import oss.process.scrum.service.OrganizationService;
import oss.process.scrum.service.UserService;

@ManagedBean(name = "organizationManagedBean")
@SessionScoped
public class OrganizationManagedBean implements Serializable {
    private static final long serialVersionUID = 7739087584554721913L;
    @ManagedProperty(value = "#{organizationService}")
    private OrganizationService organizationService;
    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    private List<Organization> organizations;
    private List<Organization> selectedOrganizations;
    private List<Organization> filteredOrganizations;
    private Organization organization;

    /**
     * @return the organizations
     */
    public List<Organization> getOrganizations() {
        return organizations;
    }

    /**
     * @param organizations the organizations to set
     */
    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    /**
     * @return the selectedOrganizations
     */
    public List<Organization> getSelectedOrganizations() {
        return selectedOrganizations;
    }

    /**
     * @param selectedOrganizations the selectedOrganizations to set
     */
    public void setSelectedOrganizations(List<Organization> selectedOrganizations) {
        this.selectedOrganizations = selectedOrganizations;
    }

    /**
     * @return the filteredOrganizations
     */
    public List<Organization> getFilteredOrganizations() {
        return filteredOrganizations;
    }

    /**
     * @param filteredOrganizations the filteredOrganizations to set
     */
    public void setFilteredOrganizations(List<Organization> filteredOrganizations) {
        this.filteredOrganizations = filteredOrganizations;
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

    /**
     * @return the organizationService
     */
    public OrganizationService getOrganizationService() {
        return organizationService;
    }

    /**
     * @param organizationService the organizationService to set
     */
    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostConstruct
    public void initalize() {
        organization = new Organization();
        organization.initializeUsers();

        try {
            organizations = organizationService.retrieveAll();
        } catch (AppException e) {
            organizations = new ArrayList<Organization>();
        }
    }

    public void createOrganization() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.getOrganization().setId(UUID.randomUUID().toString());
        this.getOrganization().setStatus(ScrOrganization.Status.ACTIVE.toString());

        try {
            organizationService.create(getOrganization());
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Organization was created successfully!", this.getOrganization().toString()));
        } catch (AppException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error creating organization.", e.getLocalizedMessage()));
        }
    }

    public void updateOrganization(RowEditEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        Organization editedOrganization = ((Organization) event.getObject());

        try {
            organizationService.update(editedOrganization);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Organization was updated successfully!", editedOrganization.toString()));
        } catch (AppException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error updating organization.", e.getLocalizedMessage()));
        }
    }

    public void reset() {
        organization = null;
        organization = new Organization();
    }

    public List<User> completeUsers(String query) {
        return userService.getUsers(query);
    }
}
