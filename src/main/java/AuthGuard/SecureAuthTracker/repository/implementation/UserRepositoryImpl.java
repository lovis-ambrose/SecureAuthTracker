package AuthGuard.SecureAuthTracker.repository.implementation;

import AuthGuard.SecureAuthTracker.domain.Role;
import AuthGuard.SecureAuthTracker.domain.User;
import AuthGuard.SecureAuthTracker.exceptions.ApiException;
import AuthGuard.SecureAuthTracker.repository.RoleRepository;
import AuthGuard.SecureAuthTracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static AuthGuard.SecureAuthTracker.enumeration.RoleType.ROLE_USER;
import static AuthGuard.SecureAuthTracker.queries.UserQuery.*;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {
//    for querying the db
    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository<Role> roleRepository;

    @Override
    public User create(User user) {
        // make sure mail is unique
        if (getEmailCount(user.getEmail().trim().toLowerCase()) > 0) {
            throw new ApiException("Email already in use. Try different email.");
        }
        // save new user
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameters, holder);
            user.setId(requireNonNull(holder.getKey()).longValue());
            // add role to user
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());
            // send verification url
            // save url in verification table
            // send email to user with verification url
            // return newly created user
            // if any errors, throw appropriate exception
        }
        catch (EmptyResultDataAccessException exception) {

        }
        catch (Exception exception) {
            //
        }
        return null;
    }

    @Override
    public Collection<User> list(int page, int pageSize) {
        return List.of();
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(User user) {
    }
}
