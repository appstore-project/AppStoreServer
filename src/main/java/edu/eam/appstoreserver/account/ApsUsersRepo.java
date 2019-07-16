package edu.eam.appstoreserver.account;

import org.springframework.data.repository.CrudRepository;

public interface ApsUsersRepo extends CrudRepository<ApsUser, Long> {
    //Optional<ApsUser> findByUsername(String username);
    ApsUser findByUsername(String username);
}