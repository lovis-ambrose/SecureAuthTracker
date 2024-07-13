package AuthGuard.SecureAuthTracker.services.implementation;

import AuthGuard.SecureAuthTracker.domains.User;
import AuthGuard.SecureAuthTracker.dto.UserDTO;
import AuthGuard.SecureAuthTracker.dtoMapper.UserDTOMapper;
import AuthGuard.SecureAuthTracker.repositories.UserRepository;
import AuthGuard.SecureAuthTracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}
