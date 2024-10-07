package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Source;
import mentorship.dailydev.dailydev.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceServiceImpl implements SourceService{
    @Autowired
    private SourceRepository sourceRepository;
    @Override
    public Source getOrSave(String domain) {
        if(isSourceDuplicated(domain)){
            return sourceRepository.getBy(domain);
        }
        return sourceRepository.save(domain);
    }

    private boolean isSourceDuplicated(String domain) {
        Source source = sourceRepository.getBy(domain);
        if(source == null){
            return false;
        }
        return true;
    }
}
