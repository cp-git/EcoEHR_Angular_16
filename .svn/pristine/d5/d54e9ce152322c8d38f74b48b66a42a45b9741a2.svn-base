package com.cpa.ehr.backend.dao.admin.entities;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity 
@Table(name="password_reset_token")
public class PasswordResetToken {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "staff_member_id_seq", allocationSize=1)
	@Column(name="id")
    private Long id; 

    @Column(nullable = false, unique = true)
    private String token;

    @OneToOne
	@JoinColumn(name = "staff_id", nullable = false)
	private StaffMember staffMember;

	@Column(nullable = false)
    private Date expiryDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public StaffMember getStaffMember() {
        return staffMember;
    }

    public void setStaffMember(StaffMember staffMember) {
        this.staffMember = staffMember;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setExpiryDate(int hour){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.HOUR, hour);
        this.expiryDate = now.getTime();
    }

    public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }
    
    
    @Override
   	public String toString() {
   		return "PasswordResetToken [id=" + id + ", token=" + token + ", staffMember=" + staffMember + ", expiryDate="
   				+ expiryDate + "]";
   	}
}
