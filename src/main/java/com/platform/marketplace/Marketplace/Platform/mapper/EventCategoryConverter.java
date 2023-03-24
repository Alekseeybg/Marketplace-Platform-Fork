package com.platform.marketplace.Marketplace.Platform.mapper;

import com.platform.marketplace.Marketplace.Platform.model.EventCategory;
import com.platform.marketplace.Marketplace.Platform.service.event.EventCategoryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventCategoryConverter {
    @Autowired
    private EventCategoryService eventCategoryService;

    public  List<EventCategory> convertToEventCategories(String eventCategoriesString) {
        List<String> categoryNames = new ArrayList<>(Arrays.asList(eventCategoriesString.split("\\s*,\\s*|\\s+")));
        List<EventCategory> categories = new ArrayList<>();
        for (String categoryName : categoryNames) {
            if (!categoryName.isEmpty() && eventCategoryService.findCategoryByValue(categoryName)==null) {
                EventCategory eventCategory = new EventCategory(categoryName.trim().toLowerCase());
                categories.add(eventCategory);
            } else {
                categories.add(eventCategoryService.findCategoryByValue(categoryName));
            }
        }
        return categories;
    }

    public String convertToString(List<EventCategory> eventCategories){
        return eventCategories.stream().map(EventCategory :: getType).collect(Collectors.joining(", "));
    }
}
