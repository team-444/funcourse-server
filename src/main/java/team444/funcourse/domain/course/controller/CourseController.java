package team444.funcourse.domain.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team444.funcourse.domain.auth.dto.CustomUserDetails;
import team444.funcourse.domain.course.dto.CreateCourseRequest;
import team444.funcourse.domain.course.service.CourseService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public Long createCourse(
        @AuthenticationPrincipal CustomUserDetails userDetails,
        @RequestBody CreateCourseRequest request
    ) {
        return courseService.createCourse(userDetails, request);
    }

}
