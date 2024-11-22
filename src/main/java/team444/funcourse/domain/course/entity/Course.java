package team444.funcourse.domain.course.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team444.funcourse.domain.spot.entity.Spot;
import team444.funcourse.domain.user.entity.User;
import team444.funcourse.global.common.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "courses")
public class Course extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Spot> spots = new ArrayList<>();

    private int duration;
    private String description;

    @Builder
    public Course(User creator, List<Spot> spots, int duration, String description) {
        this.creator = creator;
        for (Spot spot : spots) {
            this.getSpots().add(spot);
            spot.relateCourse(this);
        }
        this.duration = duration;
        this.description = description;
    }
}
