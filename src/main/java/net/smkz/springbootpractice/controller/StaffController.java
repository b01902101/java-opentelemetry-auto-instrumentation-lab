package net.smkz.springbootpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import net.smkz.springbootpractice.dto.BaseResponseDTO;
import net.smkz.springbootpractice.dto.ModifyStaffDTO;
import net.smkz.springbootpractice.dto.StaffDTO;
import net.smkz.springbootpractice.dto.UpdateStaffDTO;
import net.smkz.springbootpractice.service.IStaffService;
import net.smkz.springbootpractice.util.GenerateResponseUtil;

@RestController
@RequestMapping("/staff")
@Tag(name = "Staff", description = "與員工相關的 APIs.")
public class StaffController {
	@Autowired
	private IStaffService staffService;
	
	/**
	 * 取得所有員工資料
	 * @return 所有員工資料
	 */
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "取得所有員工資料", description = "取得所有員工資料")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "成功取得所有員工資料"),
			@ApiResponse(
					responseCode = "500",
					description = "遭遇未知的錯誤")
	})
	public ResponseEntity<BaseResponseDTO<List<StaffDTO>>> getAllStaff() {
		List<StaffDTO> staffs = staffService.getAllStaff();
		
		return ResponseEntity.ok(
				GenerateResponseUtil.generate(staffs));
	}
	
	/**
	 * 建立員工資料
	 * @param request 員工資料
	 * @return 新員工資料
	 */
	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "建立員工資料", description = "建立員工資料")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "成功建立員工資料"),
			@ApiResponse(
					responseCode = "400",
					description = "員工資料輸入有誤"),
			@ApiResponse(
					responseCode = "500",
					description = "遭遇未知的錯誤")
	})
	public ResponseEntity<BaseResponseDTO<StaffDTO>> createStaff(
			@Valid @RequestBody ModifyStaffDTO request) {
		StaffDTO newStaff = staffService.createStaff(request);
		
		return ResponseEntity.ok(
				GenerateResponseUtil.generate(newStaff));
	}
	
	/**
	 * 更新員工資料
	 * @param request 員工資料
	 * @return 更新的員工資料
	 */
	@PostMapping(value = "/",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "更新員工資料", description = "更新員工資料")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "成功建立員工資料"),
			@ApiResponse(
					responseCode = "400",
					description = "員工資料輸入有誤"),
			@ApiResponse(
					responseCode = "500",
					description = "遭遇未知的錯誤")
	})
	public ResponseEntity<BaseResponseDTO<StaffDTO>> updatStaff(
			@Valid @RequestBody UpdateStaffDTO request) {
		StaffDTO updatedStaff = staffService.updateStaff(request);
		
		return ResponseEntity.ok(
				GenerateResponseUtil.generate(updatedStaff));
	}
	
	/**
	 * 刪除員工資料
	 * @param id 員工編號
	 * @return 刪除結果
	 */
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "刪除員工資料", description = "硬刪除員工資料")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "成功建立員工資料"),
			@ApiResponse(
					responseCode = "400",
					description = "員工資料輸入有誤"),
			@ApiResponse(
					responseCode = "500",
					description = "遭遇未知的錯誤")
	})
	public ResponseEntity<BaseResponseDTO<Object>> deleteStaff(
			@PathVariable("id") Integer id) {
		staffService.deleteStaff(id);
		
		return ResponseEntity.ok(
				GenerateResponseUtil.generate("刪除員工資料成功"));
	}
}
