package com.zakrzewski.eglos.annotation.resolver;

import com.zakrzewski.eglos.annotation.CustomerSession;
import com.zakrzewski.eglos.exceptions.GeneralException;
import com.zakrzewski.eglos.exceptions.NotFoundException;
import com.zakrzewski.eglos.utils.AppCoreConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

public class CustomerSessionResolver implements HandlerMethodArgumentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerSessionResolver.class);

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.getParameterType().equals(CustomerSession.class);
    }

    @Override
    public Object resolveArgument(final MethodParameter parameter,
                                  final ModelAndViewContainer mavContainer,
                                  final NativeWebRequest webRequest,
                                  final WebDataBinderFactory binderFactory) throws Exception {
        if (parameter.hasParameterAnnotation(CustomerSession.class)) {
            final HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
            String sessionId = Objects.requireNonNull(httpServletRequest).getHeader(AppCoreConstants.CustomerSession.X_APP_SESSION);
            if (StringUtils.isEmpty(sessionId)) {
                LOG.error("Session Id is empty or null: {}", sessionId);
                throw new NotFoundException("Invalid or expired session");
            }
            final String[] splitedSessionId = sessionId.split("\\.");
            sessionId = splitedSessionId[0];
        }

        throw new GeneralException("Customer session annotation error");
    }
}
