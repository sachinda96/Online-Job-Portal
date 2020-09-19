package lk.joinus.jobportal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class JobPoster {
    @Id
    private String username;
    private String email;
    private String companyname;
    private String password;



    public JobPoster() {
    }

    public JobPoster(String username, String email, String companyname, String password) {
        this.username = username;
        this.email = email;
        this.companyname = companyname;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JobPoster{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", companyname='" + companyname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
