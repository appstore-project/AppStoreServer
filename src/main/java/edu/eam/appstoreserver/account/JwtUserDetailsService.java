package edu.eam.appstoreserver.account;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    ApsUsersRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApsUser apsUser = userRepo.findByUsername(username);
        if (apsUser ==null) {
            throw new UsernameNotFoundException("ApsUser not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                apsUser.getUsername(), apsUser.getPassword(), new ArrayList<>());
    }
}