package team444.funcourse.domain.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team444.funcourse.domain.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
