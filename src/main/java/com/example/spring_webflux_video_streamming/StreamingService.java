package com.example.spring_webflux_video_streamming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Created by Amimul Ehsan
 * Date: 29/12/2021
 * Project Name : spring_webflux_video_streamming
 */

@Service
public class StreamingService {

    private static final String FORMAT = "classpath:videos/%s.mp4";

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo( String title ) {
        return Mono.fromSupplier(() ->
                resourceLoader.getResource(String.format(FORMAT, title)));
    }
}
