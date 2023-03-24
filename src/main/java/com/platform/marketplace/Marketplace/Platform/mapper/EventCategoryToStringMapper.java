package com.platform.marketplace.Marketplace.Platform.mapper;

import com.platform.marketplace.Marketplace.Platform.model.EventCategory;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class EventCategoryToStringMapper implements Function<List<EventCategory>,List<String>> {

    @Override
    public List<String> apply(List<EventCategory> categories) {
        return categories.stream().map(EventCategory :: getType).collect(Collectors.toList());
    }
}
