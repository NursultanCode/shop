package com.attractor.shop.entities;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class UserResponseDto {
    private Long id;
    private String fullname;
    private String email;

    public static UserResponseDto from(User user) {
        return builder()
                .id(user.getId())
                .fullname(user.getFullname())
                .email(user.getEmail())
                .build();
    }
}

