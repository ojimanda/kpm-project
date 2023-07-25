package id.yozi.kpmservice.repository;

import id.yozi.kpmservice.model.SubmitKPM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmitKPMRepository extends JpaRepository<SubmitKPM, Long> {
}
