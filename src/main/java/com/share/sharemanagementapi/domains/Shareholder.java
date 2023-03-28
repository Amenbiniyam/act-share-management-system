package com.share.sharemanagementapi.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity(name = "tbl_shareholders")
@Data
public class Shareholder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "First Name cannot be empty")
    private String firstName;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Middle name cannot be empty")
    private String middleName;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "OwnerShip type cannot be empty")
    private String ownershipType;

    @Column(nullable = true)
    @NotNull(message = "Date of birth must be set")
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Phone number cannot be empty")
    private String phoneNumber;

    @Column(nullable = false, unique = false)
    @NotBlank(message = "Address cannot be empty")
    private String address;

    @Column(nullable = false)
    private LocalDate createdDate = LocalDate.now();

//    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "firstName")
//    private User user;
}

// EXAMPLE OF SETTER AND GETTER METHODS
//    public String getFirstName() {
//        return firstName.toUpperCase();
//    }
//    public void setFirstName(String firstName) {
//        //validation
//        this.firstName = firstName;
//    }
//    Account myAccount = new Account();
//FAIL myAccount.firstName = "Biniam";
//CORRECT myAccount.setFirstName("Biniam");

