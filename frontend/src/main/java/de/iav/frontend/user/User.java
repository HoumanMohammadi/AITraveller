package de.iav.frontend.user;

public record User(
        String id,
        String firstName,
        String lastName,
        String email,
        //String password,
        String role

) {
}
