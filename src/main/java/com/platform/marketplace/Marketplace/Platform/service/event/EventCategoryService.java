package com.platform.marketplace.Marketplace.Platform.service.event;

import com.platform.marketplace.Marketplace.Platform.dto.EventCategoryDTO;
import com.platform.marketplace.Marketplace.Platform.mapper.EventCategoryToStringMapper;
import com.platform.marketplace.Marketplace.Platform.model.EventCategory;
import com.platform.marketplace.Marketplace.Platform.repository.EventCategoryRepository;
import java.util.HashSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventCategoryService {

    private final EventCategoryRepository eventCategoryRepository;

    private final EventCategoryToStringMapper eventCategoryToStringMapper;

    public HashSet<EventCategory> findEventCategoriesByValues(HashSet<EventCategoryDTO> values){
        return eventCategoryRepository.findEventCategoriesByValue(values);
    }

    public List<EventCategory> getAllEventCategories() {
        return eventCategoryRepository.findAll();
    }

    public List<String> getAllCategoriesToString() {
        return eventCategoryToStringMapper.apply(getAllEventCategories());
    }

    public EventCategory findCategoryByValue(String value){
        return eventCategoryRepository.findCategoryByValue(value);
    }

    public void saveEventCategory(EventCategory eventCategory){
        eventCategoryRepository.save(eventCategory);
    }

    public void saveEventCategories(List<EventCategory>categories){
        eventCategoryRepository.saveAll(categories);
    }

    public void saveEventCategoriesFromList(List<EventCategory> eventCategories){
        eventCategories.forEach(category -> {
            if (findCategoryByValue(category.getType()) == null) {
                saveEventCategory(category);
            }
        });
    }
}
