package my.englishkate.service;

import my.englishkate.dto.AnswerCreateDTO;
import my.englishkate.entity.AnswerEntity;
import my.englishkate.mapper.AnswerMapper;
import my.englishkate.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private AnswerMapper answerMapper;

    public AnswerEntity getById(Long id) {
        AnswerEntity answer = answerRepository.findById(id).orElseThrow();
        return answer;
    }

    public AnswerEntity create(AnswerCreateDTO createDTO) {
        AnswerEntity answer = answerMapper.map(createDTO);
        boolean result = answer.getAnswerText().equals(answer.getQuestion().getAnswerText());
        answer.setResult(result);
        answerRepository.save(answer);
        return answer;
    }
}
