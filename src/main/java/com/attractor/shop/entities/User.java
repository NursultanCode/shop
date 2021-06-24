package com.attractor.shop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name="users")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User extends BaseEntity{
    @Email
    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String email;

    @NotBlank
    @Size(min = 8, max = 128)
    @Column(length = 128)
    private String password;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String fullname;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    @Builder.Default
    private String role = "USER";
}
