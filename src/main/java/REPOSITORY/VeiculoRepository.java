package REPOSITORY;

import MODELS.ENTITY.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}
