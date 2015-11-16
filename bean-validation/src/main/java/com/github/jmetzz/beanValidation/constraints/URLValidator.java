package com.github.jmetzz.beanValidation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;


public class URLValidator implements ConstraintValidator<URL, String> {

    private String protocol;
    private String host;
    private int port;


    @Override
    public void initialize(URL url) {
        this.protocol = url.protocol();
        this.host = url.host();
        this.port = url.port();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        /*
        The Bean Validation specification recommends as good practice to consider null as valid.
        This way you do not duplicate the code of the @NotNull constraint.
         */
        if (value == null || value.length() == 0) {
            return true;
        }

        java.net.URL url;
        try {
            // Transforms it to a java.net.URL to see if it has a valid format
            url = new java.net.URL(value);
        } catch (MalformedURLException e) {
            return false;
        }

        // Checks if the protocol attribute has a valid value
        if (protocol != null && protocol.length() > 0 && !url.getProtocol().equals(protocol)) {
            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("{com.github.jmetzz.beanValidation.constraints.URL.protocol.message}").addConstraintViolation()
            context.buildConstraintViolationWithTemplate("Invalid protocol")
                    .addConstraintViolation();
            return false;
        }

        if (host != null && host.length() > 0 && !url.getHost().startsWith(host)) {
            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("{com.github.jmetzz.beanValidation.constraints.URL.host.message}").addConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid host").addConstraintViolation();
            return false;
        }

        if (port != -1 && url.getPort() != port) {
            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("{com.github.jmetzz.beanValidation.constraints.URL.port.message}").addConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid port").addConstraintViolation();
            return false;
        }

        return true;
    }

}
