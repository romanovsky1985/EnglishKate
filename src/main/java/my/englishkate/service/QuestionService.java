package my.englishkate.service;

import my.englishkate.dto.QuestionCreateDTO;
import my.englishkate.entity.QuestionEntity;
import my.englishkate.mapper.QuestionMapper;
import my.englishkate.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionMapper questionMapper;

    public QuestionEntity getById(Long id) {
        QuestionEntity question = questionRepository.findById(id).orElseThrow();
        return question;
    }

    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    public QuestionEntity create(QuestionCreateDTO createDTO) {
        QuestionEntity question = questionMapper.map(createDTO);
        questionRepository.save(question);
        return question;
    }
}
