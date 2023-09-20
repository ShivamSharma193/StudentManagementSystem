package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.ModuleSubject;

public interface ModuleSubjectRepo extends JpaRepository<ModuleSubject, Long> {

//	@Modifying
//	@Query("select moduleName from ModuleSubject where course_id=:courseId and subject_id=:subjectId")
//	Optional<List<String>> findByCourseIdAndSubjectId(Long courseId, Long subjectId);


//	@Query("select moduleName,status from ModuleSubject where course_id=:courseId and subject_id=:subjectId")
//	Optional<List<ModuleStatusDto>> findModuleAndStatusList(Long courseId, Long subjectId);
 
	@Modifying
	@Query("select moduleName from ModuleSubject where course_id=:courseId and subject_id=:subjectId")
	List<String> findByCouseIdAndSubjectId(Long courseId, Long subjectId);

	
	@Modifying
	@Query("select status from ModuleSubject where course_id=:courseId and subject_id=:subjectId")
	List<String> findStatusByCouseIdAndSubjectId(Long courseId, Long subjectId);


	

	@Modifying
	@Query("update ModuleSubject set status='C' where moduleName=:completedModule and course_id=:courseId and subject_id=:subjectId")
	void updateModuleStatus(String completedModule, Long courseId, Long subjectId);
	


	
	


}
