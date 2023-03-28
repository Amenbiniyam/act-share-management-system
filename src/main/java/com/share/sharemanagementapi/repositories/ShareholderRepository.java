package com.share.sharemanagementapi.repositories;

import com.share.sharemanagementapi.domains.Shareholder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareholderRepository extends CrudRepository<Shareholder, Long> {
}
