package models;

class AdminUser extends BasicUser {

    public AdminUser(String email, String password, String firstname, String lastname, String account_type) {
        super(email, password, firstname, lastname, account_type);
    }
}
