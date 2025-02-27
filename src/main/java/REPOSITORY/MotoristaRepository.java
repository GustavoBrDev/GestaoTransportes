package REPOSITORY;

import MODELS.ENTITY.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Integer> {
}
