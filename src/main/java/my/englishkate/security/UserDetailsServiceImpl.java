package my.englishkate.security;

import my.englishkate.service.StudentService;
import my.englishkate.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return studentService.getByUsername(username);
        } catch (Exception ignored) {};
        try {
            return teacherService.getByUsername(username);
        } catch (Exception ignored) {};
        throw new UsernameNotFoundException(username);
    }
}
