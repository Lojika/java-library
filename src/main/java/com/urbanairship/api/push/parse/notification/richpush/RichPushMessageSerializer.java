package com.urbanairship.api.push.parse.notification.richpush;

import com.urbanairship.api.push.model.notification.richpush.RichPushMessage;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class RichPushMessageSerializer extends JsonSerializer<RichPushMessage> {
    @Override
    public void serialize(RichPushMessage message, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("title", message.getTitle());
        jgen.writeStringField("body", message.getBody());
        jgen.writeStringField("content_type", message.getContentType());
        jgen.writeStringField("content_encoding", message.getContentEncoding());
        if (message.getExtra().isPresent()) {
            jgen.writeObjectField("extra", message.getExtra().get());
        }
        jgen.writeEndObject();
    }
}
