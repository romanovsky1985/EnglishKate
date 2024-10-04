package my.englishkate.mapper;

import my.englishkate.dto.StudentCreateDTO;
import my.englishkate.dto.StudentOpenDTO;
import my.englishkate.entity.StudentEntity;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(uses = {ReferenceMapper.class},
    componentModel = MappingConstants.ComponentModel.SPRING,
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
    @Mapping(target = "teacher", source = "teacherId")
    public abstract StudentEntity map(StudentCreateDTO createDTO);

    public abstract StudentOpenDTO map(StudentEntity entity);


}
