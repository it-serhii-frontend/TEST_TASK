package com.table.one.mod;



import javax.persistence.*;
import javax.validation.constraints.*;


@Entity(name = "customer")
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "fullName")
    @NotEmpty(message = "Between 2 and 50 chars")
    @Size(min = 2, max = 50)
    private String fullName;

    @Column(name = "email")
    @Email(message = "Email should be valid, Between 2 and 100 chars")
    @Size(min = 2, max = 100)
    private String email;

    @Column(name = "phoneNumber")
    @Pattern(regexp = "^(\\+\\d{6,14}$)?")
    private String phone;
    
    @Column(name = "is_active")
    private boolean state;
   
    @Column(name = "created")
    public Long created = 0L; 
    
    @Column(name = "updated")
    public Long updated = 0L;
	

	
	

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Long getUpdated() {
		return updated;
	}

	public void setUpdated(Long updated) {
		this.updated = updated;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	


}
