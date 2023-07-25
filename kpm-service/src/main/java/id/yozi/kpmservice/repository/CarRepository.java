package id.yozi.kpmservice.repository;

import id.yozi.kpmservice.model.CarKPM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarKPM, Long> {
    CarKPM findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}
