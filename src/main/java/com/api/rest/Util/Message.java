package com.api.rest.Util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Message enumeration defines a series of error messages that can be used throughout the application.
 * Each enumeration element represents a specific error message.
 *
 * This enumeration is used to standardize error messages and avoid the repetition of magic strings in the code.
 *
 * @author Julian1699
 * @version 1.0
 */
@AllArgsConstructor
public enum Message {
    PRODUCT_NOT_FOUND("El producto no fue encontrado"),
    PRODUCT_SAVED("El producto se guardó correctamente"),
    PRODUCT_UPDATED("El producto fue actualizado"),
    PRODUCT_DELETED("El producto fue eliminado"),
    EMPTY("No hay productos disponibles"),
    BAD_REQUEST("Mala peticion, recuerda: Las peticiones no deben ir vacias o incompletas),");

    private final String message;

}
