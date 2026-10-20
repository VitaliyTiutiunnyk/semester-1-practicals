package semester1.practice06;

public class UserAccount {
    private String username;
    private String password;
    public void setCredentials(String u, String p){
        username=u; password=p;

    }
    public boolean login(String enteredUser, String enteredPass){
        return username.equals(enteredUser) && password.equals(enteredPass);
    }
    public void changePassword(String oldPass, String newPass) {
        if (password.equals(oldPass)) {
            password = newPass;
            System.out.println("Пароль успішно змінено");
        } else {
            System.out.println("Старий пароль неправильний");
        }
    }
}
