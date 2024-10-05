package my.englishkate.mapper;

import my.englishkate.dto.AnswerCreateDTO;
import my.englishkate.dto.AnswerOpenDTO;
import my.englishkate.entity.AnswerEntity;
import org.mapstruct.*;

@Mapper(uses = {ReferenceMapper.class},
componentModel = MappingConstants.ComponentModel.SPRING,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AnswerMapper {
    @Mapping(target = "student", source = "studentId")
    @Mapping(target = "question", source = "questionId")
    public abstract AnswerEntity map(AnswerCreateDTO createDTO);

    @Mapping(target = "questionText", source = "question.questionText")
    @Mapping(target = "questionId", source = "question.id")
    @Mapping(target = "studentId", source = "student.id")
    public abstract AnswerOpenDTO map(AnswerEntity entity);
}
