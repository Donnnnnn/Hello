package com.zit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zit.page.UserImpl;
import com.zit.page.UserUtil;

@Controller
public class HomeController {
    
	@Autowired
	public UserImpl userimpl;
	
	@RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
    
    
    @RequestMapping(value="/list")  
    public String home(Model model,HttpServletRequest request,HttpServletResponse response){  
        Map<String, Object> resultMap = new HashMap<>();  
        List<SysUser> list;  
        try {  
            list = userimpl.getAll();  
            // 查询表单或分页保持请求时 请求参数的接收  
            Map<String, String> serArgs = new HashMap<String, String>();  
            serArgs = UserUtil.getSelArgsToMap(request);//这个类在下面给出  
            resultMap = userimpl.getUserBySearch(serArgs, "id"); //按id字段排序
            //页面调用resultMap即可取值
            model.addAttribute("resultMap",resultMap);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        return "datatable";  
    }  
}