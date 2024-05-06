package dev.anadinema.projects.persistence.converter;

import io.vertx.core.json.JsonArray;
import jakarta.persistence.AttributeConverter;

import java.util.List;

public class JsonConverter<T> implements AttributeConverter<List<T>, JsonArray> {

    @Override
    public JsonArray convertToDatabaseColumn(List<T> courseList) {
        return new JsonArray(courseList);
    }

    @Override
    public List<T> convertToEntityAttribute(JsonArray objects) {
        return objects.getList();
    }

}
