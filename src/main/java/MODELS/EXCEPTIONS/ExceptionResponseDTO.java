package MODELS.EXCEPTIONS;

import java.time.Instant;

public record ExceptionResponseDTO(String message, String details, Instant timestamp) {
}
