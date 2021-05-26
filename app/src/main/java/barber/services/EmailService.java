package barber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@PropertySource(value = "classpath:email.properties")
public class EmailService {
    private String username;
    private String password;
    private Properties properties;

    Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Properties emailProperties() {
        this.password = environment.getProperty("mail.smtp.password");
        this.username = environment.getProperty("mail.smtp.username");
        properties = new Properties();
        properties.put("mail.smtp.auth", environment.getProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable", environment.getProperty("mail.smtp.starttls.enable"));
        properties.put("mail.smtp.host", environment.getProperty("mail.smtp.host"));
        properties.put("mail.smtp.port", environment.getProperty("mail.smtp.port"));

        return properties;
    }

    @Async
    public void sendMessage(String subject, String text) {
        emailProperties();
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(environment.getProperty("mail.smtp.receiver")));

            message.setSubject(subject);

            message.setText(text);

            Transport.send(message);
        } catch (MessagingException exception) {
            throw new RuntimeException(exception);
        }
    }
}
