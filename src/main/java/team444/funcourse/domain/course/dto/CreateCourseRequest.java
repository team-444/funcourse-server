package team444.funcourse.domain.course.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team444.funcourse.domain.spot.dto.CreateSpotRequest;

@Getter
@NoArgsConstructor
public class CreateCourseRequest {

    private int duration;
    private String description;
    private List<CreateSpotRequest> spots;

}
