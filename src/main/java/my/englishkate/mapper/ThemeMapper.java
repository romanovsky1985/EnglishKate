package my.englishkate.mapper;

import my.englishkate.dto.ThemeCreateDTO;
import my.englishkate.dto.ThemeOpenDTO;
import my.englishkate.entity.ThemeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapping;

@Mapper(uses = {ReferenceMapper.class},
    componentModel = MappingConstants.ComponentModel.SPRING,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ThemeMapper {
    @Mapping(target = "teacher", source = "teacherId")
    public abstract ThemeEntity map(ThemeCreateDTO createDTO);
    @Mapping(target = "teacherId", source = "teacher.id")
    public abstract ThemeOpenDTO map(ThemeEntity entity);
}
