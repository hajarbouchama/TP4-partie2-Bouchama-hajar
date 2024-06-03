package ma.bouchama.tp4partie3bouchamahajar.dtos;

import lombok.*;
import ma.bouchama.tp4partie3bouchamahajar.entities.PaymentStatus;
import ma.bouchama.tp4partie3bouchamahajar.entities.PaymentType;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
}

