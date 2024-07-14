package com.epam.training.jhony_soto.fundamental.services;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The TestDataReader class provides methods to retrieve test data from a ResourceBundle.
 * It initializes the ResourceBundle based on the system property "environment".
 */
public class TestDataReader {

    /**
     * ResourceBundle instance that holds the test data.
     */
    private static final ResourceBundle resourceBundle;

    // Static initializer for the ResourceBundle
    static {
        // Load the ResourceBundle based on the "environment" system property
        String environment = System.getProperty("environment");
        if (environment == null) {
            throw new IllegalArgumentException("System property 'environment' is not set. Please set it to run Tests correctly.");
        }

        try {
            resourceBundle = ResourceBundle.getBundle(environment);
        } catch (MissingResourceException e) {
            throw new IllegalArgumentException("ResourceBundle '" + environment + "' not found. Please check if the 'environment' system property is correctly set.", e);
        }
    }

    /**
     * Retrieves the test data associated with the specified key from the ResourceBundle.
     *
     * @param key The key used to retrieve the test data.
     * @return The test data value associated with the given key.
     */
    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
