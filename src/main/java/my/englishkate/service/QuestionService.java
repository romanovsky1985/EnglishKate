package my.englishkate.service;

import my.englishkate.model.QuestionModel;
import my.englishkate.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public QuestionModel getById(Long id) {
        QuestionModel question = questionRepository.findById(id).orElseThrow();
        return question;
    }
}
