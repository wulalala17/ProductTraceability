package fruittracing0.demo.Controller;

import fruittracing0.demo.StaffPO.Staff;
import fruittracing0.demo.service.ImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Controller
public class FileController {
    @Autowired
    private ImgService imgService;

    @Value("${com.staff0}")
    //获取主机端口
    private String post;

    private String host; //获取本机ip

    private String rootPath = "E:";//图片存放根路径

    private String sonPath = "/img/";//图片存放根目录下的子目录

    private String imgPath;//获取图片链接

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);


    @GetMapping("/UploadProfile")
    public String index(Model model,HttpServletRequest httpServletRequest){
        String imgPath = (String) httpServletRequest.getSession().getAttribute("imgPath");
        //System.out.println("index:" + imgPath);
        model.addAttribute("imgPath",imgPath);
        return "index";
    }

    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("test") MultipartFile file, HttpServletRequest httpServletRequest) {
        //返回上传的文件是否为空，即没有选择任何文件，或者所选文件没有内容。
        //防止上传空文件导致奔溃
        if (file.isEmpty()) {
            return "文件为空";
        }

        //获取本机IP
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("get server host Exception e:", e);
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        //logger.info("上传的文件名为：" + fileName);
        // 设置文件上传后的路径
        String filePath = rootPath + sonPath;
        logger.info("上传的文件路径" + filePath);
        logger.info("整个图片路径：" + host + ":" + post + sonPath + fileName);
        //创建文件路径
        File dest = new File(filePath + fileName);

        String imgPath = ("http://" + host + ":" + post + sonPath + fileName).toString();

        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            //假如文件不存在即重新创建新的文件已防止异常发生
            dest.getParentFile().mkdirs();
        }
        try {
            //transferTo（dest）方法将上传文件写到服务器上指定的文件
            file.transferTo(dest);
            //将链接保存到URL中
            Staff staffTest = imgService.editprofile(new Staff(),imgPath);
            //Img imgTest = imgService.add(new Img(), imgPath);
            HttpSession session = httpServletRequest.getSession();//import javax.servlet.http.HttpSession;
            session.setAttribute("imgPath",imgPath);
            return "上传成功";
        } catch (Exception e) {
            return "上传失败";
        }
    }
}

