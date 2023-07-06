package assignment.assignment_prm392.model.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "customer", schema = "Agricultural")
public class CustomerDTO {
    private Long id;

    private assignment.assignment_prm392.model.dto.RoleDTO role;

    private String email;

    private String password;

    private String fullName;

    private String phone;

    private String address;

    private String gender;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public CustomerDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    public assignment.assignment_prm392.model.dto.RoleDTO getRole() {
        return role;
    }

    public CustomerDTO setRole(assignment.assignment_prm392.model.dto.RoleDTO role) {
        this.role = role;
        return this;
    }

    @Column(name = "email", length = 100)
    public String getEmail() {
        return email;
    }

    public CustomerDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "password", length = 50)
    public String getPassword() {
        return password;
    }

    public CustomerDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(name = "full_name", length = 100)
    public String getFullName() {
        return fullName;
    }

    public CustomerDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Column(name = "phone", length = 10)
    public String getPhone() {
        return phone;
    }

    public CustomerDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Column(name = "address", length = 200)
    public String getAddress() {
        return address;
    }

    public CustomerDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    @Column(name = "gender", length = 10)
    public String getGender() {
        return gender;
    }

    public CustomerDTO setGender(String gender) {
        this.gender = gender;
        return this;
    }

}