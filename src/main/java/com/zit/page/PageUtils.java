package com.zit.page;

import java.util.HashMap;  
import java.util.Map;  

import org.apache.commons.lang3.StringUtils;  
import org.springframework.data.domain.Page;  
import org.springframework.data.domain.PageRequest;  
import org.springframework.data.domain.Sort;  
import org.springframework.data.domain.Sort.Direction;  

public class PageUtils {  

 /**  
   * 封装分页数据到resultMap中。  
   */  
  public static Map<String, Object> getPageMap(Page<?> objPage) {  
        
      Map<String, Object> resultMap = new HashMap<String, Object>();  

      resultMap.put("resultList", objPage.getContent()); // 数据集合  
      resultMap.put("totalNum", objPage.getTotalElements()); // 总记录数  
      resultMap.put("totalPage", objPage.getTotalPages()); // 总页数  
      resultMap.put("pageNum", objPage.getNumber()); // 当前页码  
      resultMap.put("pageSize", objPage.getSize()); // 每页显示数量  

      return resultMap;  
  }  

  /**  
   * 创建分页请求。  
   *  
   * @param pageNum 当前页  
   * @param pageSize 每页条数  
   * @param sortType 排序字段  
   * @param direction 排序方向  
   */  
  public static PageRequest buildPageRequest(int pageNum, int pageSize, String sortType, String direction) {  
      Sort sort = null;  
        
      if (!StringUtils.isNotBlank(sortType)) {  
          return new PageRequest(pageNum - 1, pageSize);  
      } else if (StringUtils.isNotBlank(direction)) {  
          if (Direction.ASC.equals(direction)) {  
              sort = new Sort(Direction.ASC, sortType);  
          } else {  
              sort = new Sort(Direction.DESC, sortType);  
          }  
          return new PageRequest(pageNum - 1, pageSize, sort);  
      } else {  
          sort = new Sort(Direction.ASC, sortType);  
          return new PageRequest(pageNum - 1, pageSize, sort);  
      }  
  }  

  /**  
   * 创建分页请求(该方法可以放到util类中).  
   */  
  public static PageRequest buildPageRequest(int pageNum, int pageSize, String sortType) {  
      return buildPageRequest(pageNum, pageSize, sortType, null);  
  }  
    
  /**  
   * 创建分页请求  
   *   
   * @param pageNum  
   * @param pageSize  
   * @param sort  
   * @return  
   */  
  public static PageRequest buildPageRequest(int pageNum, int pageSize, Sort sort) {  
      return new PageRequest(pageNum - 1, pageSize, sort);  
  }  

  /**  
   * 创建分页请求(该方法可以放到util类中).  
   */  
  public static PageRequest buildPageRequest(int pageNum, int pageSize) {  
      return buildPageRequest(pageNum, pageSize, null, null);  
  }  

}  