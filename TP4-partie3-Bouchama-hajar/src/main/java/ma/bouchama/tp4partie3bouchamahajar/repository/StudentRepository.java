package ma.bouchama.tp4partie3bouchamahajar.repository;

import ma.bouchama.tp4partie3bouchamahajar.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String>
{
    Student findByCode(String code);
    List<Student> findByProgramId(String programId);
}
