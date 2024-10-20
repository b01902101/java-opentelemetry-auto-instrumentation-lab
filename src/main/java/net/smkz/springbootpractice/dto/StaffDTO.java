package net.smkz.springbootpractice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "員工資料")
public class StaffDTO {
	/**
	 * 員工編號
	 */
	@Schema(description = "員工編號")
	private Integer id;
	
	/**
	 * 員工電子郵件
	 */
	@Schema(description = "員工電子郵件")
	private String email;
	
	/**
	 * 員工電話號碼
	 */
	@Schema(description = "員工電話號碼")
	private String phone;
	
	/**
	 * 員工職位
	 */
	@Schema(description = "員工職位")
	private String position;
}
