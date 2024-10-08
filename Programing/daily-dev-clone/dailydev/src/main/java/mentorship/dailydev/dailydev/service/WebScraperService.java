package mentorship.dailydev.dailydev.service;

import mentorship.dailydev.dailydev.domain.RssLink;
import mentorship.dailydev.dailydev.domain.dto.RssLinkDTO;

import java.io.IOException;
import java.util.List;

public interface WebScraperService {
    List<RssLinkDTO> getAllRssLinkFrom(String url) throws IOException;
}
