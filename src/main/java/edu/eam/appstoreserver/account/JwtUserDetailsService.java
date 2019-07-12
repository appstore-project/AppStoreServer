package edu.eam.appstoreserver.account;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    AppUsersRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findByUsername(username);
        if (appUser ==null) {
            throw new UsernameNotFoundException("AppUser not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                appUser.getUsername(), appUser.getPassword(), new ArrayList<>());
    }
}