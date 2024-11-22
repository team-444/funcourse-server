package team444.funcourse.domain.place.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team444.funcourse.domain.place.entity.Place;
import team444.funcourse.domain.place.repository.PlaceRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceService {

    private final PlaceRepository placeRepository;

    private Long registerPlace(String id) {
        Place place = Place.builder()
            .externalPlaceId(id)
            .build();
        placeRepository.save(place);

        return place.getId();
    }

}
