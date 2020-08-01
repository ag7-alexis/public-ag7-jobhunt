package ag7.dev.trainSecurity.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ag7.dev.trainSecurity.data.UserRepository;
import ag7.dev.trainSecurity.model.User;

/**
 * Service to loads data of a specific-user 
 */

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUsername(username);
        if (!user.isPresent()) throw new UsernameNotFoundException("");
        UserPrincipal userPrincipal = new UserPrincipal(user.get());
        return userPrincipal;
    }

    
}