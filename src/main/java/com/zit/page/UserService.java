package com.zit.page;

import java.util.List;
import java.util.Map;

import com.zit.SysUser;

public interface UserService {

	public List<SysUser> getAll() throws Exception;
	
	public SysUser save(SysUser users) throws Exception;  
    
    public Map<String, Object> getUserBySearch(Map<String, String> userArgs, final String sortType) throws Exception; 
	
}
