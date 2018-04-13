package com.zit.page;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {

	/**  
     * 封装从前台传递过来的查询参数。  
     *   
     */  
    public static Map<String, String> getSelArgsToMap(HttpServletRequest request) throws Exception {  
        Map<String, String> serArgs = new HashMap<String, String>();  
  
//        String FamilyName = request.getParameter("FamilyName");  
//        String Mobile = request.getParameter("Mobile");  
  
          
        String pageNum = request.getParameter("pageNum") == null ? "1" : request.getParameter("pageNum");  
        String pageSize = request.getParameter("pageSize") == null ? "10" : request.getParameter("pageSize");  
  
//        serArgs.put("FamilyName", FamilyName);  
//        serArgs.put("Mobile", Mobile);  
          
        serArgs.put("pageNum", pageNum);  
        serArgs.put("pageSize", pageSize);  
  
        return serArgs;  
    }  
}
