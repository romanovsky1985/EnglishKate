package my.englishkate.mapper;

import my.englishkate.dto.StudentCreateDTO;
import my.englishkate.entity.StudentEntity;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class StudentMapper {
    @Autowired
    PasswordEncoder passwordEncoder;

    @BeforeMapping
    public void encodePassword(StudentCreateDTO createDTO) {
        String password = createDTO.getPassword();
        createDTO.setPassword(passwordEncoder.encode(password));
    }
    public abstract StudentEntity map(StudentCreateDTO createDTO);


}
