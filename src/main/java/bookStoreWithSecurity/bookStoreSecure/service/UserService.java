package bookStoreWithSecurity.bookStoreSecure.service;

import bookStoreWithSecurity.bookStoreSecure.dto.UserRegistrationDto;
import bookStoreWithSecurity.bookStoreSecure.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

}
