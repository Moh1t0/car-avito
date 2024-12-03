package com.javaacademy.car_avito.controller;

import com.javaacademy.car_avito.Announcement;
import com.javaacademy.car_avito.service.AnnouncementStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementStorage announcementStorage;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAnnouncement(@RequestBody Announcement announcement) {
        announcementStorage.save(announcement);
    }

    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable Integer id) {
        return announcementStorage.getById(id).orElseThrow();
    }

    @GetMapping
    public List<Announcement> getAllAnnouncement() {
        return announcementStorage.getAll();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteAnnouncementById(@PathVariable Integer id) {
        return announcementStorage.deleteById(id);
    }

    @GetMapping("/search")
    public List<Announcement> searchByParameters(@RequestParam(required = false) String brandName,
                                                 @RequestParam(required = false) String color,
                                                 @RequestParam(required = false) BigDecimal price) {
        return announcementStorage.search(brandName, color, price);
    }
}
