package models;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Validated
public class BasicUser extends User {


    public BasicUser(String email, String password, String firstname, String lastname, String account_type) {
        super(email, password, firstname, lastname, account_type);
    }

    @Override
    @NotNull(message = "Password cannot be null")
    @Size(min = 7, message = "Password must be at least 7 characters!")
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    @Pattern(regexp = "BASIC|PREMIUM", message = "Account Type must be either BASIC or PREMIUM")
    @NotNull(message = "Account Type must not be empty")
    public String getAccountType() {
        return super.getAccountType();
    }

    @Override
    @Pattern(regexp = "^[a-zA-Z]+((\\s|\\-)[a-zA-Z]+)?$", message = "First name must be a valid name")
    @NotNull(message = "First name cannot be null")
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    @Pattern(regexp = "^[a-zA-Z]+((\\s|\\-)[a-zA-Z]+)?$", message = "Last name must be a valid name")
    @NotNull(message = "Last name cannot be null")
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "You must supply a valid email") //reference https://regexlib.com/Search.aspx?k=email&c=-1&m=-1&ps=20
    @NotNull(message = "Email cannot be null")
    public String getEmail() {
        return super.getEmail();
    }
}

