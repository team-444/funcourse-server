package team444.funcourse.domain.spot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team444.funcourse.domain.course.entity.Course;
import team444.funcourse.domain.place.entity.Place;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "spots", uniqueConstraints = @UniqueConstraint(columnNames = {
    "course_id", "daySequence", "placeSequence"}))
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spot_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    private int daySequence;
    private int placeSequence;
    private String memo;

    @Builder
    public Spot(Place place, int daySequence, int placeSequence, String memo) {
        this.place = place;
        this.daySequence = daySequence;
        this.placeSequence = placeSequence;
        this.memo = memo;
    }

    public void relateCourse(Course course) {
        this.course = course;
    }
}
