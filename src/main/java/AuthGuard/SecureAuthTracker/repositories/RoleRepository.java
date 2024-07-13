package AuthGuard.SecureAuthTracker.repositories;


import AuthGuard.SecureAuthTracker.domains.Role;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoleRepository <T extends Role>{
    // basic CRUD operations
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    // More complex Operations
    void addRoleToUser(Long userId, String roleName);
    Role getRoleUserId(Long userId);
    Role getRoleByUserEmail(String email);
    void updateUserRole(Long userId, String roleName);
}
