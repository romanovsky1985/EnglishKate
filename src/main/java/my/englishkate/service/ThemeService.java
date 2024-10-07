package my.englishkate.service;

import my.englishkate.dto.ThemeCreateDTO;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.exception.ResourceNotFoundException;
import my.englishkate.mapper.ThemeMapper;
import my.englishkate.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;
    @Autowired
    private ThemeMapper themeMapper;

    public ThemeEntity getById(Long id) {
        ThemeEntity theme = themeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Тема не найдена"));
        return theme;
    }

    public ThemeEntity create(ThemeCreateDTO createDTO) {
        ThemeEntity theme = themeMapper.map(createDTO);
        themeRepository.save(theme);
        return theme;
    }

    public void deleteById(Long id) {
        themeRepository.deleteById(id);
    }
}
