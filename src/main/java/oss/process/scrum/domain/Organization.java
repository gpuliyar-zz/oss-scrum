package oss.process.scrum.domain;

import java.io.Serializable;

public class Organization implements Serializable {
    private static final long serialVersionUID = 9063747009972356099L;
    private String id;
    private String name;
    private String code;
    private String description;
    private String action;
    private String status;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }
    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Organization{" + "id=" + id + ", name=" + name + ", code=" + code + ", description=" + description + ", action=" + action + ", status=" + status + '}';
    }
}
