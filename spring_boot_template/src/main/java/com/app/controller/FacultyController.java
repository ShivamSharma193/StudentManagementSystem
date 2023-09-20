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

import com.app.dto.CompletedFacultyDto;
import com.app.dto.CourseSubjectDto;
import com.app.dto.CurrentFacultyDto;
import com.app.dto.FacultyCourseDto;
import com.app.dto.FacultyDto;
import com.app.dto.FacultyModuleDto;
import com.app.dto.FacultyTimeTableDto;
import com.app.dto.TimeTableDto;
import com.app.service.FacultyService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/faculty")

public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	
	@GetMapping("/profile/{loginId}")
	public FacultyDto getFacultyDetails(@PathVariable Long loginId) {
		
		CurrentFacultyDto currentFacultyDto=new CurrentFacultyDto(loginId);
		
		return facultyService.getFacultyDetails(currentFacultyDto);
	}
	
	@GetMapping("/timeTable/{id}/{selectedCourse}")	
	public TimeTableDto getTimeTable(@PathVariable Long id,@PathVariable String selectedCourse){
		
		FacultyTimeTableDto facultyTimeTableDto = new FacultyTimeTableDto(id,selectedCourse);
		
		try {
			return facultyService.getTimeTable(facultyTimeTableDto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@PostMapping("/course")
	public List<String> getCourseList(@RequestBody CurrentFacultyDto currentFacultyDto)
	{
		return facultyService.getCourseList(currentFacultyDto);
	}

	@PostMapping("/course/subject")
	public List<String> getSubjectList(@RequestBody FacultyCourseDto facultyCourseDto)
	{
		return facultyService.getSubjectList(facultyCourseDto);
	}
	@PostMapping("/course/subject/module")
	public FacultyModuleDto getModuleList(@RequestBody CourseSubjectDto courseSubjectDto)
	{
		return facultyService.getModuleList(courseSubjectDto);
	}
	
	@PostMapping("/course/subject/modulecompleted")
	public String getCompletedModules(@RequestBody CompletedFacultyDto completedFacultyDto)
	{
		System.out.println(completedFacultyDto.getCourseName());
		System.out.println(completedFacultyDto.getSubjectName());
		System.out.println(completedFacultyDto.getModulesList());
		return facultyService.getCompletedModules(completedFacultyDto);
	}
}
