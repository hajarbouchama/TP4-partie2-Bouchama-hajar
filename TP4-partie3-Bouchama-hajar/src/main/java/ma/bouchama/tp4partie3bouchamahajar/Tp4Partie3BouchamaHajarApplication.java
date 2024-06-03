package ma.bouchama.tp4partie3bouchamahajar;

import ma.bouchama.tp4partie3bouchamahajar.entities.Payment;
import ma.bouchama.tp4partie3bouchamahajar.entities.PaymentStatus;
import ma.bouchama.tp4partie3bouchamahajar.entities.PaymentType;
import ma.bouchama.tp4partie3bouchamahajar.entities.Student;
import ma.bouchama.tp4partie3bouchamahajar.repository.PaymentRepository;
import ma.bouchama.tp4partie3bouchamahajar.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class Tp4Partie3BouchamaHajarApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp4Partie3BouchamaHajarApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository)
    {
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("112233").firstName("Mohamed").programId("SDIA").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("112244").firstName("Imane").programId("GLSID").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("112255").firstName("Alae").programId("IAAD").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .code("112266").firstName("Najat").programId("GLSID").build());

            PaymentType[] paymentTypes = PaymentType.values();
            Random random=new Random();
            studentRepository.findAll().forEach(st->{
                for (int i = 0; i <10 ; i++)
                {
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment = Payment.builder()
                            .amount(1000+(int)(Math.random()*20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });
        };
    }

}
