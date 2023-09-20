package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddLoginDto;
import com.app.dto.AddStudentDto;
import com.app.dto.AttendanceDto;
import com.app.dto.CourseNameDto;
import com.app.dto.CurrentSupportDto;
import com.app.dto.SupportDto;
import com.app.dto.UpdateAttendanceDto;
import com.app.service.SupportService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/support")
public class SupportController {

	@Autowired
	private SupportService supportService;

	@GetMapping("/profile/{loginId}")
	public SupportDto getSupportDetails(@PathVariable Long loginId) {
		
		CurrentSupportDto currentSupportDto = new CurrentSupportDto(loginId);
		return supportService.getSupportDetails(currentSupportDto);
	}

	@PostMapping("/course")
	public List<String> getCoursesList() {
		return supportService.getCoursesList();
	}

	@GetMapping("/course/attendance/{selectedCourse}")
	public AttendanceDto getStudentAndSubjectList(@PathVariable String selectedCourse ) {
		
		CourseNameDto courseNameDto = new CourseNameDto(selectedCourse);
		return supportService.getStudentAndSubjectList(courseNameDto);
	}

	@PostMapping("course/attendance/updateAttendance")
	public String updateAttandance(@RequestBody UpdateAttendanceDto updateAttandanceDto) {

		return supportService.updateAttandance(updateAttandanceDto);

	}

	@GetMapping("/addlogin/{email}/{password}")
	public String createLogin(@PathVariable String email,@PathVariable String password) {
		
		AddLoginDto addLoginDto=new AddLoginDto(email,password);
		return supportService.createLogin(addLoginDto);
	}

	@PostMapping("/addlogin/addStudent")
	public String createStudent(@RequestBody AddStudentDto addStudentDto) {
		return supportService.createStudent(addStudentDto);
	}

	@PostMapping(value="/uploadTimetable", consumes="multipart/form-data")
	public String uploadTimeTable(@RequestParam String date,@RequestParam MultipartFile image,@RequestParam String course) {

		//System.out.print(date);
		//System.out.print(uploadTimeTableDto.getImage());
		//System.out.print(uploadTimeTableDto.getCourseName());
		return supportService.uploadTimeTable(date,image,course);

	}

}
