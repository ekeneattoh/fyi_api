package models;

public class UserFactory {

    public static User getUser(String account_type, User user) {

        switch (account_type) {

            case "BASIC":
                return (BasicUser) user;

            case "ADMIN":
                return (AdminUser) user;

            default:
                throw new IllegalArgumentException("You need to supply a valid user type");
        }
    }
}
