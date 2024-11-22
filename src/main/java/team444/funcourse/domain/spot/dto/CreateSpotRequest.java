package team444.funcourse.domain.spot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateSpotRequest {

    private String externalPlaceId;
    private int daySequence;
    private int placeSequence;
    private String memo;

}
