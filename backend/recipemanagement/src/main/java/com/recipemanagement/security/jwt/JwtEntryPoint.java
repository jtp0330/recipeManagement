// package com.recipemanagement.security.jwt;

// import java.io.IOException;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.AuthenticationEntryPoint;
// import org.springframework.stereotype.Component;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// //handles protected routes
// //unauthorized access
// @Component
// public class JwtEntryPoint implements AuthenticationEntryPoint {

// private static final Logger logger =
// LoggerFactory.getLogger(JwtEntryPoint.class);

// @Override
// public void commence(HttpServletRequest request, HttpServletResponse
// response,
// AuthenticationException authException) throws IOException, ServletException {
// System.out.println(request);
// logger.error("Unauthorized error: {}", authException.getMessage());
// response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error:
// Unauthorized");
// }

// }