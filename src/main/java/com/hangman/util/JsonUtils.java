package com.hangman.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;


public final class JsonUtils {

    private JsonUtils() {
    }

    public static String toJson(Object value) throws JsonGenerationException, JsonMappingException, IOException {
        JacksonObjectMapper mapper = new JacksonObjectMapper();
        return mapper.writeValueAsString(value);
    }
}

class JacksonObjectMapper extends ObjectMapper {

    public JacksonObjectMapper() {
        configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
    }
}