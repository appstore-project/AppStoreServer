package edu.eam.appstoreserver.account;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final PasswordEncoder bCryptPassEncoder;
    private final AppUsersRepo appUsersRepoRepo;

    public UserController(AppUsersRepo appUsersRepoRepo, PasswordEncoder bCryptPassEncoder) {
        this.bCryptPassEncoder = bCryptPassEncoder;
        this.appUsersRepoRepo = appUsersRepoRepo;
    }

    @PostMapping("/register")
    public void signUp(@RequestBody AppUser appUser) {
        appUser.setPassword(bCryptPassEncoder.encode(appUser.getPassword()));
        appUsersRepoRepo.save(appUser);
    }
}
