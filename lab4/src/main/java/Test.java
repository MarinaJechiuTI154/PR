import java.util.Properties;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Test {
    public static void main(String[] args) throws MessagingException {
        String host =  "pop.mail.gmail.com";
        Email email = new Email("marinajq9%@gmail.com", "marinajechiu10081995");
        Properties properties = System.getProperties();
        Session session = Session.getDefaultInstance(properties);
        Store store = session.getStore("pop3");
        store.connect(host, email.getLogin(), email.getPassword());
        Folder inbox = store.getFolder("Inbox");

    }

}
