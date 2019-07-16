package edu.eam.appstoreserver.account;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final PasswordEncoder bCryptPassEncoder;
    private final ApsUsersRepo apsUsersRepoRepo;

    public UserController(ApsUsersRepo apsUsersRepoRepo, PasswordEncoder bCryptPassEncoder) {
        this.bCryptPassEncoder = bCryptPassEncoder;
        this.apsUsersRepoRepo = apsUsersRepoRepo;
    }

    @PostMapping("/register")
    public void signUp(@RequestBody ApsUser apsUser) {
        apsUser.setPassword(bCryptPassEncoder.encode(apsUser.getPassword()));
        apsUsersRepoRepo.save(apsUser);
    }
}
