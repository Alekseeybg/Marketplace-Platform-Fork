package com.platform.marketplace.Marketplace.Platform.utility.seeder;

import com.platform.marketplace.Marketplace.Platform.model.EventCategory;
import com.platform.marketplace.Marketplace.Platform.repository.EventCategoryRepository;
import com.platform.marketplace.Marketplace.Platform.utility.consts.ListOfCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategorySeeder implements CommandLineRunner {

    private final EventCategoryRepository eventCategoryRepository;

    private final ListOfCategories categories;

    @Override
    public void run(String... args) throws Exception {
        if (eventCategoryRepository.findAll().size() == 0 && eventCategoryRepository.findAll().size() < 11) {
            for (String categoryName : categories.getCategories()) {
                EventCategory category = new EventCategory();
                category.setType(categoryName);
                eventCategoryRepository.save(category);
            }
        }
    }
}
