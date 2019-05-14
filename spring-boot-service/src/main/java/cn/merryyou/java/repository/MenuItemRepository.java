package cn.merryyou.java.repository;

import cn.merryyou.java.domain.MenuItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long>{

	@Query("select t from MenuItem t where t.parentId = :parentId")
	List<MenuItem> findMenuItemByParentId(Long parentId);
}
