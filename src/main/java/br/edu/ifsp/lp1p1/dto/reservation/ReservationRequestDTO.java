package br.edu.ifsp.lp1p1.dto.reservation;

public record ReservationRequestDTO(Long employeeId,
                                    short daysAhead,
                                    String returnDate) {
}
