package team444.funcourse.global.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import team444.funcourse.domain.auth.dto.CustomUserDetails;
import team444.funcourse.domain.user.entity.User;
import team444.funcourse.domain.user.entity.UserRole;

public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    public JWTFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorization.split(" ")[1];
        if (jwtUtil.isExpired(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String email = jwtUtil.getEmail(token);
        String role = jwtUtil.getRole(token);

        User user = User.builder()
            .email(email)
            .password("")
            .role(UserRole.valueOf(role))
            .build();
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            customUserDetails, null,
            customUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }
}
