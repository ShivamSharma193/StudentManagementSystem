package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CurrentStudentIdDto;
import com.app.dto.ModuleDto;
import com.app.dto.StudentDto;
import com.app.dto.StudentMarksArrayObjectDto;
import com.app.dto.SubjectCourseDto;
import com.app.dto.TimeTableDto;
import com.app.service.StudentService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")

public class StudentController {

	@Autowired
	private StudentService studentService;
//	CurrentStudentIdDto
//	@PostMapping("/profile")
	@GetMapping("/home/{loginId}")
	public StudentDto getStudentDetails(@PathVariable Long loginId ) {
		
		CurrentStudentIdDto currentStudentIdDto = new CurrentStudentIdDto(loginId);

		return studentService.getStudentDetails(currentStudentIdDto);
	}

	@GetMapping("/subjects/{loginId}")
	public List<String> getSubjectsList(@PathVariable Long loginId) {
		
		CurrentStudentIdDto currentStudentIdDto = new CurrentStudentIdDto(loginId);

		return studentService.getSubjectsList(currentStudentIdDto);
	}

	@GetMapping("/modules/{subjectName}/{studentId}")
	public ModuleDto getSubjectModules(@PathVariable String subjectName,@PathVariable Long studentId ) {
		
		SubjectCourseDto subjectCourseDto = new SubjectCourseDto(subjectName,studentId);

		return studentService.getModuleList(subjectCourseDto);

	}

	@GetMapping("/subjectMarks/{loginId}")
	public List<StudentMarksArrayObjectDto> getSubjectMarks(@PathVariable Long loginId) {
		
		CurrentStudentIdDto currentStudentIdDto = new CurrentStudentIdDto(loginId);

		return studentService.getSubjectMarks(currentStudentIdDto);

	}

	@GetMapping("/attendance/{loginId}")
	public float getStudentAttendence(@PathVariable Long loginId) {
		
		CurrentStudentIdDto currentStudentIdDto = new CurrentStudentIdDto(loginId);

		
		return studentService.getStudentAttendence(currentStudentIdDto);		
		
	}
	
	@GetMapping("/timeTable/{id}")	
	public TimeTableDto getTimeTable(@PathVariable Long id ){
		
		CurrentStudentIdDto currentStudentIdDto = new CurrentStudentIdDto(id); 
		
		try {
			return studentService.getTimeTable(currentStudentIdDto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
