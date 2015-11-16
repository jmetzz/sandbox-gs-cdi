package com.github.jmetzz.beanValidation.constraints;

/**
 * Created by Jean Metz on 16-Nov-15.
 */

@USA
public class ZipCodeChecker {

    public boolean isZipCodeValid(String code) {

        // Apply the validation logic here over code parameter.
        // In real scenario we could ask an external service
        // to check whether the given code really exists in USA.
        // For testing purposes just return true
        return code != null;
    }
}
