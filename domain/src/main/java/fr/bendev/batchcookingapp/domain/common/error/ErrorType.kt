package fr.bendev.batchcookingapp.domain.common.error

/**
 * Generic error enum class that can be added to to encapsulate all the different errors found in the app
 * All the most common server code error are included in this class
 * -1 is reserved for unknown error (a catch-all code)
 */
enum class ErrorType(val code: Int) {
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    PRECONDITION_FAILED(412),
    INTERNAL_SERVICE_ERROR(500),
    SERVICE_UNAVAILABLE(503),
    UNKNOWN_ERROR(-1);

    companion object {
        fun fromCode(code: Int): ErrorType = values().find { it.code == code } ?: UNKNOWN_ERROR
    }
}