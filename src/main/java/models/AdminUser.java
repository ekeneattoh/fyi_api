package models;

class AdminUser extends User {

    public AdminUser(String email, String password, String firstname, String lastname, String username, String account_type) {
        super(email, password, firstname, lastname, username, account_type);
    }
}
