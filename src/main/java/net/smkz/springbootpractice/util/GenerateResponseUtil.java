package net.smkz.springbootpractice.util;

import net.smkz.springbootpractice.dto.BaseResponseDTO;

public class GenerateResponseUtil {
	
	private GenerateResponseUtil() {}
	
	/**
	 * 產生回應
	 * @param <T> 資料型別
	 * @param message 錯誤訊息
	 * @param data 回應資料
	 * @return 標準回應格式
	 */
	public static <T> BaseResponseDTO<T> generate(String message, T data) {
		return new BaseResponseDTO<T>(message, data);
	}
	
	/**
	 * 產生回應
	 * @param <T> 資料型別
	 * @param data 回應資料
	 * @return 標準回應格式
	 */
	public static <T> BaseResponseDTO<T> generate(T data) {
		return generate("", data);
	}
	
	/**
	 * 產生回應
	 * @param message 錯誤訊息
	 * @return 標準回應格式
	 */
	public static BaseResponseDTO<Object> generate(String message) {
		return generate(message, null);
	}
}
