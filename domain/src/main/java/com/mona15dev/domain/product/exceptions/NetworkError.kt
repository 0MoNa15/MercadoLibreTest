package com.mona15dev.domain.product.exceptions

enum class NetworkError(val code: Int, val message: String) {
    BAD_REQUEST(400, "Solicitud incorrecta"),
    FORBIDDEN(403, "Acceso denegado"),
    NOT_FOUND(404, "Recurso no encontrado"),
    SERVER_ERROR(500, "Error del servidor"),
    UNKNOWN_ERROR(0, "Error desconocido del cliente")
}