package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.Announcement;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class AnnouncementStorage {

    private final Map<Integer, Announcement> data = new HashMap<>();
    private Integer count = 0;

    public void save(Announcement announcement) {
        if (announcement == null) {
            throw new IllegalArgumentException("announcement = null!");
        }
        count++;
        announcement.setId(count);
        data.put(count, announcement);
    }

    public Optional<Announcement> getById(Integer id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Announcement> getAll() {
        return data.values().stream().toList();
    }

    public Boolean deleteById(Integer id) {
        return data.remove(id) != null;
    }

    public List<Announcement> search(String brandName, String color, BigDecimal price) {
        return data.values().stream()
                .filter(announcement ->
                        (brandName == null || Objects.equals(announcement.getBrandName(), brandName))
                         && (color == null || Objects.equals(announcement.getColor(), color))
                         && (price == null || Objects.equals(announcement.getPrice(), price))
                )
                .toList();
    }
}
