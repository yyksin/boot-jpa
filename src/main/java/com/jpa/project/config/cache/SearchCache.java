package com.jpa.project.config.cache;

import com.jpa.project.entity.T_SEARCH;
import com.jpa.project.repository.SearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IMC021 on 2017. 9. 6..
 */
@Component
public class SearchCache {

    Logger logger = LoggerFactory.getLogger(SearchCache.class);

    @Autowired
    SearchRepository searchRepository;

    @Cacheable(value = "searchCache")
    public List<T_SEARCH> getAllMemo(){
        long start = System.currentTimeMillis();
        List<T_SEARCH> list = searchRepository.findAll();
        long end = System.currentTimeMillis();
        logger.info("Cache 수행시간 : "+Long.toString(end-start));

        return list;
    }

    /**
     * 캐시 refresh
     */
    @CacheEvict(value = "searchCache", allEntries = true)
    public void refreshAll(){

    }
}
