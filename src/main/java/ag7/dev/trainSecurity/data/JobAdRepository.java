package ag7.dev.trainSecurity.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ag7.dev.trainSecurity.model.JobAd;

@Repository
public interface JobAdRepository extends JpaRepository<JobAd, Long> {
   
}