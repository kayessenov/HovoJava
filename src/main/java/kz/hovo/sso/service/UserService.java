package kz.hovo.sso.service;

import kz.hovo.sso.entity.Users;
import kz.hovo.sso.entity.enums.ERole;
import kz.hovo.sso.exceptions.UserExistException;
import kz.hovo.sso.payload.request.SignUpRequest;
import kz.hovo.sso.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users createUser(SignUpRequest userIn){
        Users users = new Users();
        users.setEmail(userIn.getEmail());
        users.setName(userIn.getFirstname());
        users.setLastname(userIn.getLastname());
        users.setUsername(userIn.getUsername());
        users.setPassword(passwordEncoder.encode(userIn.getPassword()));
        users.getRoles().add(ERole.ROLE_USER);
        try {
            LOG.info("Saving User {}", userIn.getEmail());
            return userRepository.save(users);
        }catch (Exception e){
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user " + users.getUsername() + " already exist. Please check credentials");
        }
    }
}
