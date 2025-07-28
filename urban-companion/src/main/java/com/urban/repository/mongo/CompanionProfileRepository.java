package com.urban.repository.mongo;

import com.urban.model.document.CompanionProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanionProfileRepository extends MongoRepository<CompanionProfile, String> {
    List<CompanionProfile> findByLocationAndAvailableTrue(String location);
}
