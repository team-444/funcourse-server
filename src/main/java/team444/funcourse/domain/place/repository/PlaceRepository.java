package team444.funcourse.domain.place.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import team444.funcourse.domain.place.entity.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByExternalPlaceId(String id);
}
