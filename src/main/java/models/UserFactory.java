package models;

public class UserFactory {

    public User getUser(String user_type, String email, String password, String firstname, String lastname ){

        switch (user_type){

            case "BASIC":
                return new BasicUser(email, password, firstname, lastname);

            case "ADMIN":
                return new AdminUser(email, password, firstname, lastname);

            default:
                throw new IllegalArgumentException("You need to supply a valid user type");
        }
    }
}
