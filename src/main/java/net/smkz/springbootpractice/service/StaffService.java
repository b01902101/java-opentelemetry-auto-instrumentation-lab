package net.smkz.springbootpractice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.smkz.springbootpractice.dto.ModifyStaffDTO;
import net.smkz.springbootpractice.dto.StaffDTO;
import net.smkz.springbootpractice.dto.UpdateStaffDTO;
import net.smkz.springbootpractice.entity.Staff;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class StaffService implements IStaffService {
    // 使用 List 替代資料庫
    private List<Staff> staffList = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1); // 用於生成唯一ID
    
    @Override
    public List<StaffDTO> getAllStaff() {
        return staffList
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
        staffInfo.setId(idCounter.getAndIncrement()); // 自動生成遞增ID
        staffInfo.setEmail(request.getEmail());
        staffInfo.setPhone(request.getPhone());
        staffInfo.setPassword(request.getPassword());
        staffInfo.setPosition(request.getPosition());
        
        // 加入到 List 中
        staffList.add(staffInfo);
        
        StaffDTO newStaff = new StaffDTO();
        newStaff.setId(staffInfo.getId());
        newStaff.setPhone(staffInfo.getPhone());
        newStaff.setEmail(staffInfo.getEmail());
        newStaff.setPosition(staffInfo.getPosition());
        
        return newStaff;
    }
    
    @Override
    public StaffDTO updateStaff(UpdateStaffDTO request) {
        // 找出要更新的員工
        Staff staffToUpdate = staffList.stream()
                .filter(s -> s.getId().equals(request.getId()))
                .findFirst()
                .orElse(null);
                
        if (staffToUpdate != null) {
            // 更新值
            staffToUpdate.setEmail(request.getEmail());
            staffToUpdate.setPassword(request.getPassword());
            staffToUpdate.setPhone(request.getPhone());
            staffToUpdate.setPosition(request.getPosition());
            
            StaffDTO updated = new StaffDTO();
            updated.setId(staffToUpdate.getId());
            updated.setEmail(staffToUpdate.getEmail());
            updated.setPhone(staffToUpdate.getPhone());
            updated.setPosition(staffToUpdate.getPosition());
            
            return updated;
        }
        
        return null; // 找不到要更新的員工
    }
    
    @Override
    public boolean deleteStaff(Integer staffId) {
        int initialSize = staffList.size();
        staffList.removeIf(staff -> staff.getId().equals(staffId));
        
        // 如果 size 變小，代表有刪除成功
        return staffList.size() < initialSize;
    }
}
