package team444.funcourse.domain.course.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team444.funcourse.domain.auth.dto.CustomUserDetails;
import team444.funcourse.domain.course.dto.CreateCourseRequest;
import team444.funcourse.domain.course.entity.Course;
import team444.funcourse.domain.course.repository.CourseRepository;
import team444.funcourse.domain.place.entity.Place;
import team444.funcourse.domain.place.service.PlaceService;
import team444.funcourse.domain.spot.dto.CreateSpotRequest;
import team444.funcourse.domain.spot.entity.Spot;
import team444.funcourse.domain.user.entity.User;
import team444.funcourse.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserService userService;
    private final PlaceService placeService;

    @Transactional
    public Long createCourse(CustomUserDetails userDetails, CreateCourseRequest request) {
        User user = userService.getUserByEmail(userDetails.getUsername());

        List<Spot> spots = new ArrayList<>();
        for (CreateSpotRequest spotRequest : request.getSpots()) {
            Place place = placeService.getOrCreatePlace(spotRequest.getExternalPlaceId());
            Spot spot = Spot.builder()
                .place(place)
                .daySequence(spotRequest.getDaySequence())
                .placeSequence(spotRequest.getPlaceSequence())
                .memo(spotRequest.getMemo())
                .build();
            spots.add(spot);
        }

        Course course = Course.builder()
            .creator(user)
            .spots(spots)
            .description(request.getDescription())
            .duration(request.getDuration())
            .build();
        courseRepository.save(course);

        return course.getId();
    }
}
