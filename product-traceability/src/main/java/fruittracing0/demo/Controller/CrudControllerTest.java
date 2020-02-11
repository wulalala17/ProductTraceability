package fruittracing0.demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fruittracing0.demo.StaffPO.Staff;
import fruittracing0.demo.dao.StaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class CrudControllerTest {
    @Autowired
    StaffDao staffDao;

    @GetMapping(path="/FindAllStaff")//查询所有员工
    @ResponseBody
    public String queryAll() throws JsonProcessingException {
        List<Staff> n1 = staffDao.findAll();
        String l = "";
        for (Staff staff : n1) {
            if(staff.getIsDeleted().equals("1"))
                continue;
            ObjectMapper objectMapper = new ObjectMapper();
            //System.out.println(objectMapper.writeValueAsString(staff));转化为JSON数据
            l += objectMapper.writeValueAsString(staff) + "\n";
        }
        return l;
        //return staffDao.findAll();
    }

    @GetMapping(path="/FindStaffById")//按照ID查找员工
    @ResponseBody
    public Optional<Staff> findStaffById (@RequestParam Integer id) {
        return staffDao.findById(id);
    }

    @GetMapping(path="/AddStaff")//添加员工
    @ResponseBody
    public String addNewStaff (@RequestParam Integer id, @RequestParam String name,@RequestParam String phone) {
        Staff n = new Staff();
        n.setId(id);
        n.setName(name);
        n.setPhone(phone);
        staffDao.save(n);
        return "保存成功";
    }
    @GetMapping(path="/FindStaff")//按照名字查找员工
    @ResponseBody
    public String findStaff (@RequestParam String name) throws JsonProcessingException {
        List<Staff> n1 = staffDao.findByName(name);
        String l = "";
        if(n1.size()==0)
            return "查无此人";
        else {
            for (Staff staff : n1) {
                /*System.out.println("换行\n");
                System.out.println(staff.toString());*/
                if(staff.getIsDeleted().equals("1"))
                    continue;
                ObjectMapper objectMapper = new ObjectMapper();
                //System.out.println(objectMapper.writeValueAsString(staff));转化为JSON数据
                l += objectMapper.writeValueAsString(staff) + "\n";//参考https://cloud.tencent.com/developer/ask/178671
                //l += staff.toString();
            }
            return l;
        }
    }

    @GetMapping(path="/UpdateStaff")//修改电话号码
    @ResponseBody
    public String updateStaff (@RequestParam String name, @RequestParam String phone) throws JsonProcessingException {
        List<Staff> n1 = staffDao.findByName(name);
        //Integer i0=0;
        for (Staff staff : n1) {
            staff.setPhone(phone);
            staffDao.save(staff);
        }
        return "修改成功\n"+findStaff(name);
    }
    @GetMapping(path="/DeleteStaff")//根据名字删除员工
    @ResponseBody
    public String deleteStaff(@RequestParam String name){
        if(staffDao.findByName(name)==null)
            return "查无此人，删除失败";
        else {
            List<Staff> n1 = staffDao.findByName(name);
            //Integer i0=0;
            for (Staff staff : n1) {
                staff.setIsDeleted("1");
                staffDao.save(staff);
            }
            return "删除成功";
        }
    }

    @RequestMapping("/EditProfile")//参考https://blog.csdn.net/weixin_44141948/article/details/100562880
    public String upload(Staff staff,@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            //定义上传文件的路径
            String path1="E:\\img";
            String path2="\\upload";
            //String path = System.getProperty("stu.dir")+"\\src\\main\\resources\\static\\upload";
            String path=path1+path2;
            //上传文件的名字(包含后缀名)
            String fileName = file.getOriginalFilename();
            //用UUID创建新的名字(没有后缀名)
            Random random = new Random();
            String uuidname= String.valueOf(random.nextInt(100)).replace("-","");//用随机数来生成文件名
            //把uuid创建的名字和文件后缀名截取出来合成一个新的完整的文件名
            String getFileName = uuidname + fileName.substring(fileName.lastIndexOf("."));
            File filepath = new File(path+getFileName);
            //判断父目录是否存在
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }

            //将上传文件进行保存
            file.transferTo(new File(path + File.separator + getFileName));
            //输出可看到上传文件的路径和文件名
            System.out.println("上传文件路径和图片名称：" + (path + File.separator + getFileName));
            //将文件添加到Model中
            //model.addAttribute("filename", file.getOriginalFilename());
            staff.setProfile(path2 + File.separator + getFileName);
        }
        staffDao.save(staff);
        return "上传成功";
    }
}
