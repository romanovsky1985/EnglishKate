package my.englishkate.service;

import my.englishkate.dto.ThemeCreateDTO;
import my.englishkate.model.ThemeModel;
import my.englishkate.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    public ThemeModel getById(Long id) {
        ThemeModel theme = themeRepository.findById(id).orElseThrow();
        return theme;
    }

    public ThemeModel create(ThemeCreateDTO createDTO) {

    }
}
