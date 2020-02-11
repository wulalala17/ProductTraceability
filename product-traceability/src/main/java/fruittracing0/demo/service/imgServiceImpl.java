package fruittracing0.demo.service;

import fruittracing0.demo.StaffPO.Staff;
import fruittracing0.demo.dao.StaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ꧁ʚVVcatɞ꧂
 * @Date 2019/11/12 11:37
 * @Version 1.0
 **/
@Service
public class imgServiceImpl implements ImgService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff editprofile(Staff staff, String path) {
        staff.setProfile(path);
        return staffDao.save(staff);
    }
}
