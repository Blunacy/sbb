package com.lunacy.sbb.user;

import com.lunacy.sbb.DataNotFoundException;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public SiteUser create(String username, String email, String password) {
    SiteUser user = new SiteUser();
    user.setUsername(username);
    user.setEmail(email);
//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    BCryptPasswordEncoder : BCrypt 해싱 함수(BCrypt hashing function)를 사용해서 비밀번호를 암호화
    user.setPassword(passwordEncoder.encode(password));
    this.userRepository.save(user);
    return user;
  }

  public SiteUser getUser(String username) {
    Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
    if (siteUser.isPresent()) {
      return siteUser.get();
    } else {
      throw new DataNotFoundException("siteuser not found");
    }
  }
}
