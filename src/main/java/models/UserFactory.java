package models;

public class UserFactory {

    public static User getUser( String email, String password,
                               String firstname, String lastname, String username, String account_type ){

        switch (account_type){

            case "BASIC":
                return new BasicUser(email, password, firstname, lastname, username, account_type);

            case "ADMIN":
                return new AdminUser(email, password, firstname, lastname, username, account_type);

            default:
                throw new IllegalArgumentException("You need to supply a valid user type");
        }
    }
}
