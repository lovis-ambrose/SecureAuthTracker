package AuthGuard.SecureAuthTracker.repositories;

import AuthGuard.SecureAuthTracker.domains.User;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface UserRepository <T extends User>{
//    basic CRUD operations
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

//    More complex Operations
}
