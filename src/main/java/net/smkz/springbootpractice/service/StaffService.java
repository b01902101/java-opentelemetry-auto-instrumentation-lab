package net.smkz.springbootpractice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.smkz.springbootpractice.dto.ModifyStaffDTO;
import net.smkz.springbootpractice.dto.StaffDTO;
import net.smkz.springbootpractice.dto.UpdateStaffDTO;
import net.smkz.springbootpractice.entity.Staff;
import net.smkz.springbootpractice.repository.IStaffRepository;

@Service
public class StaffService implements IStaffService {
	@Autowired
	private IStaffRepository staffRepository;
	
	@Override
	public List<StaffDTO> getAllStaff() {
		List<Staff> staffs = this.staffRepository.findAll();
		
		return staffs
			.stream()
			.map(staff -> new StaffDTO(
					staff.getId(),
					staff.getEmail(),
					staff.getPhone(),
					staff.getPosition()))
			.collect(Collectors.toList());
	}
	
	@Override
	public StaffDTO createStaff(ModifyStaffDTO request) {
		Staff staffInfo = new Staff();
		staffInfo.setEmail(request.getEmail());
		staffInfo.setPhone(request.getPhone());
		staffInfo.setPassword(request.getPassword());
		staffInfo.setPosition(request.getPosition());
		
		Staff result = staffRepository.save(staffInfo);
		
		StaffDTO newStaff = new StaffDTO();
		newStaff.setId(result.getId());
		newStaff.setPhone(result.getPhone());
		newStaff.setEmail(result.getEmail());
		newStaff.setPosition(result.getPosition());
		
		return newStaff;
	}
	
	@Override
	public StaffDTO updateStaff(UpdateStaffDTO request) {
		Staff staff = new Staff();
		staff.setId(request.getId());
		staff.setEmail(request.getEmail());
		staff.setPassword(request.getPassword());
		staff.setPhone(request.getPhone());
		staff.setPosition(request.getPosition());
		
		Staff result = staffRepository.save(staff);
		
		StaffDTO updated = new StaffDTO();
		updated.setId(result.getId());
		updated.setEmail(result.getEmail());
		updated.setPhone(result.getPhone());
		updated.setPosition(result.getPosition());
		
		return updated;
	}
	
	@Override
	public boolean deleteStaff(Integer staffId) {
		staffRepository.deleteById(staffId);
		
		return true;
	}
}
