package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.StudentMarks;

public interface StudentMarksRepo extends JpaRepository<StudentMarks, Long> {

//	@Modifying
	@Query("select marks from StudentMarks where student_id =:studentId and course_id =:courseId")
	List<Integer> findMarksByStudentIdAndCourseId(Long studentId, Long courseId);
	
//	@Modifying
	@Query("select subject.subjectId from StudentMarks where student_id =:studentId and course_id =:courseId")
	List<Long> findSubjectIdByStudentIdAndCourseId(Long studentId, Long courseId);

}
