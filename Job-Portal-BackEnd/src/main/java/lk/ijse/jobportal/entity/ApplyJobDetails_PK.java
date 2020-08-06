package lk.ijse.jobportal.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ApplyJobDetails_PK implements Serializable {
    private Long aid;
    private String id;

    public ApplyJobDetails_PK() {
    }

    public ApplyJobDetails_PK(Long aid, String id) {
        this.aid = aid;
        this.id = id;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
