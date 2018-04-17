import java.util.ArrayList;

public class Email {
    private String login;
    private  String password;
    private  ArrayList<Message> messages ;

    public Email(String login, String password) {
        this.login = login;
        this.password = password;
        messages = new ArrayList<Message>();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
