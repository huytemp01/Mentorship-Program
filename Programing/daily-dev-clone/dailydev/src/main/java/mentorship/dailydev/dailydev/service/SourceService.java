package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.Source;

public interface SourceService{
    Source getOrSave(String domain);
}
