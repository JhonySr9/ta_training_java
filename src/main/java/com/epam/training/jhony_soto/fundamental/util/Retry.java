package com.epam.training.jhony_soto.fundamental.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Retry implements the IRetryAnalyzer interface to provide custom retry logic for failed test methods.
 */
public class Retry implements IRetryAnalyzer {
    private static final int MAX_RETRY_COUNT = 1;
    private int retryCount = 0;

    /**
     * Implements the retry logic for determining whether a test method should be retried.
     *
     * @param result The result of the test method that just ran.
     * @return True if the test method should be retried, false otherwise.
     */
    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess() && retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }
}
