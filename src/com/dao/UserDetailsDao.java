package com.dao;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.GrantedAuthorityImpl;
import com.pojo.UserDetailsImpl;

	@Repository
	public class UserDetailsDao {
		
		@Autowired
		private HibernateTemplate ht;
		
		public UserDetailsImpl loadUserDetailsByUserName(String userName){
			System.out.println(userName);
			
			UserDetailsImpl user =null;
			System.out.println(user);
			List<UserDetailsImpl> userList = (List<UserDetailsImpl>) ht.find("from UserDetailsImpl where username=?", userName);
			System.out.println("hiii");
			if(userList != null && userList.size()>0){
				user=userList.get(0);
				List<GrantedAuthorityImpl> auList = (List<GrantedAuthorityImpl>) ht.find("select a from UserDetailsImpl u join u.authorities a where u.id=?", user.getId());
				 
				 user.setAuthorities(auList);
			}
			return user;
		}

}
