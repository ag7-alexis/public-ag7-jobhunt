package ag7.dev.trainSecurity.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ag7.dev.trainSecurity.model.User;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private UserRepository userRepositoy;
    private PasswordEncoder passwordEncoder;

    public DatabaseSeeder(UserRepository userRepositoy, PasswordEncoder passwordEncoder) {
        this.userRepositoy = userRepositoy;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // User user1 = new User("admin", passwordEncoder.encode("admin"), 1, "ADMIN", "BASIC");
        // User user2 = new User("mana", passwordEncoder.encode("mana"), 1, "MANAGEMENT", "BASIC");
        // User user3 = new User("test", passwordEncoder.encode("test"), 1, "USER", "BASIC");
        
        // userRepositoy.save(user1);
        // userRepositoy.save(user2);
        // userRepositoy.save(user3);

    }

    
    
}