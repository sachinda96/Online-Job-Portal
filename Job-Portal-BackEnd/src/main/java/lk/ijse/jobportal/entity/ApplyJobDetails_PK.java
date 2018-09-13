package lk.ijse.jobportal.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ApplyJobDetails_PK implements Serializable {
    private Long aid;
    private Long id;

    public ApplyJobDetails_PK() {
    }

    public ApplyJobDetails_PK(Long aid, Long id) {
        this.aid = aid;
        this.id = id;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
