package net.smkz.springbootpractice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "標準回應格式")
public class BaseResponseDTO<T> {
	/**
	 * 錯誤訊息
	 */
	@Schema(description = "錯誤訊息")
	private String message;
	
	/**
	 * 回應資料
	 */
	@Schema(description = "回應資料")
	private T data;
}
