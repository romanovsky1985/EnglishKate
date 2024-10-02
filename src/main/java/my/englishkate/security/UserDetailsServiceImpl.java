package my.englishkate.security;

import my.englishkate.repository.StudentRepository;
import my.englishkate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    StudentService studentService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return studentService.getByUsername(username);
        } catch (Exception ignored) {};
        throw new UsernameNotFoundException(username);
    }
}
