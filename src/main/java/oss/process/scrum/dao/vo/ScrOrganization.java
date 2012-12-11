package oss.process.scrum.dao.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scr_organization")
public class ScrOrganization implements Serializable {
    private static final long serialVersionUID = 7820326405862305601L;
    public enum Status {
        ACTIVE, INACTIVE, CLOSED;
    }

    @Id
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "name")
    private String name;
    @Column(name = "short_code")
    private String shortCode;
    @Column(name = "descr")
    private String desc;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }
    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    /**
     * @return the orgName
     */
    public String getName() {
        return name;
    }
    /**
     * @param orgName the orgName to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the shortCode
     */
    public String getShortCode() {
        return shortCode;
    }
    /**
     * @param shortCode the shortCode to set
     */
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
