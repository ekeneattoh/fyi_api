package models;

class AdminUser extends User {
    public AdminUser(String email, String password, String firstname, String lastname) {
        super(email, password, firstname, lastname);
    }
}
