package com.platform.marketplace.Marketplace.Platform.utility.consts;

import java.util.Arrays;
import java.util.HashSet;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class ListOfCategories {

    private HashSet<String> categories = new HashSet<>(Arrays.asList("Концерт",
                                                                     "Театрално представление",
                                                                     "Кино прожекции",
                                                                     "Изложба на изкуство",
                                                                     "Спортни събития",
                                                                     "Конференции и семинари",
                                                                     "Фестивал",
                                                                     "Представления на живо",
                                                                     "Сватба",
                                                                     "Къмпинг",
                                                                     "Пикник",
                                                                     "Светско събитие"
    ));

    public ListOfCategories(String category) {
        this.categories.add(category);
    }
}
