package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.model.ExamPartStatus;

public interface ExamPartStatusRepository extends JpaRepository<ExamPartStatus, Long>{

	List<ExamPartStatus> findByIdExamPartStatus(Long id);

}
