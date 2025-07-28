package com.urban.controller;

import com.urban.model.document.CompanionProfile;
import com.urban.service.CompanionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companions")
@RequiredArgsConstructor
public class CompanionController {

    private final CompanionService companionService;

    @GetMapping
    public ResponseEntity<List<CompanionProfile>> list(@RequestParam(defaultValue = "Hyderabad") String location) {
        return ResponseEntity.ok(companionService.listAvailable(location));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanionProfile> get(@PathVariable String id) {
        return ResponseEntity.ok(companionService.getById(id));
    }
}
