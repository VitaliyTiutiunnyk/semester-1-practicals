package semester1.practice07;

public class User {
    private String login;
    private String email;
    private String role;
    private boolean isActive;

    // майстер-конструктор: єдине місце, де присвоюються поля
    public User(String login, String email, String role, boolean isActive) {
        this.login = login;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
    }

    public User(String login, String email) {
        this(login, email, "USER", true);
    }

    public User(String login) {
        this(login, login + "@domain.com");
    }

    public User() {
        this("guest");
    }

    public void printProfile() {
        System.out.println("Логін: " + login + " | Email: " + email
                + " | Роль: " + role + " | Активний: " + isActive);
    }
}
