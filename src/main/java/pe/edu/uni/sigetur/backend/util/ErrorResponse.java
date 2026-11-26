package pe.eedu.uni.sigetur.backend.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
}
