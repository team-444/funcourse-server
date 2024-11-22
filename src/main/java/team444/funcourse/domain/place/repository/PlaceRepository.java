package team444.funcourse.domain.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team444.funcourse.domain.place.entity.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
