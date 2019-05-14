package cn.merryyou.java.repository;

import cn.merryyou.java.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{
	@Query("select t from User t where t.name like %:name%")
	User findByName(@Param(value="name") String name);
	
	@Query("select t from User t where t.name like %:name%")
	public Page<User> findPageByName( @Param("name") String name,Pageable pageable);
}
