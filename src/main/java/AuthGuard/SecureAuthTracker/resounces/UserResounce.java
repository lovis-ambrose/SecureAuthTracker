package AuthGuard.SecureAuthTracker.resounces;

import AuthGuard.SecureAuthTracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserResounce {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<HttpResponse> registerUser
}
