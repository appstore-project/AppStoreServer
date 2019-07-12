package edu.eam.appstoreserver.account;

import org.springframework.data.repository.CrudRepository;

public interface AppUsersRepo extends CrudRepository<AppUser, Long> {
    //Optional<AppUser> findByUsername(String username);
    AppUser findByUsername(String username);
}