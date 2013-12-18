package cucumber.examples.spring.txn;

import it.verding.edo.domain.Message;
import it.verding.edo.domain.User;
import it.verding.edo.repositories.MessageRepo;
import it.verding.edo.repositories.UserRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.en.Given;

@WebAppConfiguration
@ContextConfiguration("classpath:cucumber.xml")
public class UserStepdefs {
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private MessageRepo messageRepository;

    private User user;

    public void thereIsAuser() {
        user = new User();
        user.setUsername("testuser");
        userRepository.save(user);
    }

    @Given("^a User has posted the following messages:$")
    public void a_User_has_posted_the_following_messages(List<Message> messages) throws Throwable {
        thereIsAuser();
        for (Message m : messages) {
            m.setAuthor(user);
            messageRepository.save(m);
        }
    }
}
