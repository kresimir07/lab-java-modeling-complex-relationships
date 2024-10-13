package service;

import model.Chapter;
import model.Member;
import org.springframework.stereotype.Service;
import repository.ChapterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;


    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    public List<Chapter> getAllChapters() {
        return chapterRepository.findAll();
    }

    public Optional<Chapter> getChapterById(Integer id) {
        return chapterRepository.findById(id);
    }

    public Chapter saveOrUpdateChapter(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    public void deleteChapterById(Integer id) {
        chapterRepository.deleteById(id);
    }
}
