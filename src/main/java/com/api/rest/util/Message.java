package com.api.rest.util;

import lombok.AllArgsConstructor;

/**
 * The Message enumeration defines a set of error messages that can be utilized across the application.
 * Each enum element represents a specific error message.
 *
 * This enumeration is employed to standardize error messages and eliminate the repetition of magic strings within the code.
 *
 * @author Julian1699
 * @version 1.0
 */
@AllArgsConstructor
public enum Message {
    PRODUCT_NOT_FOUND("The product was not found"),
    PRODUCT_SAVED("The product was saved successfully"),
    PRODUCT_UPDATED("The product was updated"),
    PRODUCT_DELETED("The product was deleted"),
    EMPTY("There are no available products"),
    BAD_REQUEST("Bad request, remember: Requests must not be empty or incomplete.");

    private final String message;
}
