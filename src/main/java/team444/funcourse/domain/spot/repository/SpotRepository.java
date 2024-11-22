package team444.funcourse.domain.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team444.funcourse.domain.spot.entity.Spot;

public interface SpotRepository extends JpaRepository<Spot, Long> {

}
