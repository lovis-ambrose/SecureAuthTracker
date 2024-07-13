package AuthGuard.SecureAuthTracker.services;

import AuthGuard.SecureAuthTracker.domains.User;
import AuthGuard.SecureAuthTracker.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);
}
