package ma.bouchama.tp4partie3bouchamahajar.repository;

import ma.bouchama.tp4partie3bouchamahajar.entities.Payment;
import ma.bouchama.tp4partie3bouchamahajar.entities.PaymentStatus;
import ma.bouchama.tp4partie3bouchamahajar.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
    List<Payment> findByStudentProgramId(String programId);
}
