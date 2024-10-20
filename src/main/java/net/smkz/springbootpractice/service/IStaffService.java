package net.smkz.springbootpractice.service;

import java.util.List;

import net.smkz.springbootpractice.dto.ModifyStaffDTO;
import net.smkz.springbootpractice.dto.StaffDTO;
import net.smkz.springbootpractice.dto.UpdateStaffDTO;

public interface IStaffService {

	/**
	 * 取得所有員工清單
	 * @return 所有員工清單
	 */
	public List<StaffDTO> getAllStaff();
	
	/**
	 * 建立員工資料，並返回該筆員工資料
	 * @param request 新員工資料
	 * @return 寫入資料庫的新員工資料
	 */
	public StaffDTO createStaff(ModifyStaffDTO request);
	
	/**
	 * 更新員工資料，並返回更新後的員工資料
	 * @param request 更新員工資料
	 * @return 寫入資料庫的員工資料
	 */
	public StaffDTO updateStaff(UpdateStaffDTO request);
	
	/**
	 * 刪除員工資料
	 * @param staffId 員工編號
	 * @return 刪除結果
	 */
	public boolean deleteStaff(Integer staffId);
}
