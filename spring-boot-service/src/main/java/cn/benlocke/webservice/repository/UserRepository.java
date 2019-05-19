package cn.benlocke.webservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cn.benlocke.webservice.domain.User;

public interface UserRepository extends CrudRepository<User,Long>{
	@Query("select t from User t where t.name like %:name%")
	public User findUserByName(@Param(value="name") String name);
	
	@Query("select t from User t where t.name like %:name%")
	public Page<User> findPageByName( @Param("name") String name,Pageable pageable);
	
	public List<User> findListByName(@Param("name") String name);
}
