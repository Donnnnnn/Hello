package com.zit.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;  
import javax.persistence.criteria.CriteriaQuery;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.data.domain.Page;  
import org.springframework.data.domain.Pageable;  
import org.springframework.data.jpa.domain.Specification;  
  
import javax.persistence.criteria.Predicate;  
import javax.persistence.criteria.Root;  
import javax.transaction.Transactional;  
  
import org.springframework.stereotype.Service; 

import com.zit.SysUser;

@Service  
@Transactional  
public class UserImpl implements UserService{

	@Autowired
	public UserDao userDao;
	
	@Override
	public List<SysUser> getAll() throws Exception {
		return (List<SysUser>) userDao.findAll();
	}

	@Override
	public SysUser save(SysUser users) throws Exception {
		return userDao.save(users);
	}

	@Override
	public Map<String, Object> getUserBySearch(Map<String, String> userArgs, String sortType) throws Exception {
		Pageable pageable = PageUtils.buildPageRequest(Integer.valueOf(userArgs.get("pageNum")),  
                Integer.valueOf(userArgs.get("pageSize")), sortType);  
        Page<SysUser> objPage = userDao.findAll(new Specification<SysUser>() {  
  
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {  
                List<Predicate> lstPredicates = new ArrayList<Predicate>();  
  
                 
                Predicate[] arrayPredicates = new Predicate[lstPredicates.size()];  
                return cb.and(lstPredicates.toArray(arrayPredicates));  
            }  
        }, pageable);  
  
        return PageUtils.getPageMap(objPage);  
	}

	
	
}
