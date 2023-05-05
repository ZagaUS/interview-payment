package org.zaga.deserializer;

import org.zaga.dto.EventDto;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class EventDtoDeserialization extends ObjectMapperDeserializer<EventDto> {

    public EventDtoDeserialization() {
        super(EventDto.class);
        //TODO Auto-generated constructor stub
    }
    
}
