package com.epam.training.jhony_soto.fundamental.services;

import java.util.ResourceBundle;

/**
 * The TestDataReader class provides methods to retrieve test data from a ResourceBundle.
 * It initializes the ResourceBundle based on the system property "environment".
 */
public class TestDataReader {

    /**
     * ResourceBundle instance that holds the test data.
     */
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

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
