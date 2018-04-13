package com.zit.page;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zit.SysUser;

public interface UserDao extends PagingAndSortingRepository<SysUser,Long>,JpaSpecificationExecutor<SysUser> {

	
	
}
