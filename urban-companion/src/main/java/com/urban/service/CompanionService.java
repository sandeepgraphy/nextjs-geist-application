package com.urban.service;

import com.urban.model.document.CompanionProfile;
import com.urban.repository.mongo.CompanionProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanionService {

    private final CompanionProfileRepository companionProfileRepository;

    public List<CompanionProfile> listAvailable(String location) {
        return companionProfileRepository.findByLocationAndAvailableTrue(location);
    }

    public CompanionProfile getById(String id) {
        return companionProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Companion not found"));
    }
}
