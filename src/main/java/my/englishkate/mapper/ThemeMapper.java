package my.englishkate.mapper;

import my.englishkate.dto.ThemeCreateDTO;
import my.englishkate.dto.ThemeOpenDTO;
import my.englishkate.entity.ThemeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ThemeMapper {
    public abstract ThemeEntity map(ThemeCreateDTO createDTO);
    public abstract ThemeOpenDTO map(ThemeEntity entity);
}
