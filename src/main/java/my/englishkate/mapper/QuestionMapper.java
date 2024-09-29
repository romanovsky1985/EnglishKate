package my.englishkate.mapper;

import my.englishkate.dto.QuestionCreateDTO;
import my.englishkate.dto.QuestionOpenDTO;
import my.englishkate.entity.QuestionEntity;
import org.mapstruct.*;

@Mapper(uses = {ReferenceMapper.class},
    componentModel = MappingConstants.ComponentModel.SPRING,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class QuestionMapper {
    @Mapping(target = "theme", source = "themeId")
    public abstract QuestionEntity map(QuestionCreateDTO createDTO);
    @Mapping(target = "themeId", source = "theme.id")
    public abstract QuestionOpenDTO map(QuestionEntity entity);
}
