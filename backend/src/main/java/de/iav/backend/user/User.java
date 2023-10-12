package de.iav.backend.user;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {
    @MongoId
    String id;
    String firstName;
    String lastName;
    String email;
    String password;
    String role;


    public User withId(String newId) {
        //return new User(newId, this.firstName, this.lastName, this.email, this.password, this.portfolio, this.moneyAccount);
        return new User(newId, this.firstName, this.lastName, this.email, this.password, this.role);

    }

    /*
        public NewAppUser getNewAppUser() {
                    return new NewAppUser(null, this.firstName, this.lastName, this.email, this.password);
        }
    */
    public UserWithoutUserDetails getUserWithoutUserDetails() {
        return new UserWithoutUserDetails(this.getId(), this.getFirstName(), this.getLastName(), this.getEmail(), this.getRole());
    }

}
