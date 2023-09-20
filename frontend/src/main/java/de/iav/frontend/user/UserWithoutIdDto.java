package de.iav.frontend.user;

public record UserWithoutIdDto(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
