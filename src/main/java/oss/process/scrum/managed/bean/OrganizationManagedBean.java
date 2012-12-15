package oss.process.scrum.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import oss.process.scrum.domain.Organization;
import oss.process.scrum.exception.AppException;
import oss.process.scrum.service.OrganizationService;

@ManagedBean(name = "organizationManagedBean")
@SessionScoped
public class OrganizationManagedBean implements Serializable {

    private static final long serialVersionUID = 7739087584554721913L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    @ManagedProperty(value = "#{organizationService}")
    private OrganizationService organizationService;

    private List<Organization> organizations;

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
    private Organization organization;

    @PostConstruct
    public void initalize() {
        organization = new Organization();
        organization.setStatus("ACTIVE");
        try {
            organizations = organizationService.retrieveAll();
        } catch (AppException e) {
            // TODO Ask @gpuliyar on how to handle this.
            organizations = new ArrayList<Organization>();
        }
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

    public void createOrganization() {
        FacesContext context = FacesContext.getCurrentInstance();
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

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
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
