package cn.benlocke.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.benlocke.webservice.domain.MenuItem;

public interface MenuItemRepository extends CrudRepository<MenuItem,Long>{

	@Query("select t from MenuItem t where t.parentId = :parentId")
	List<MenuItem> findMenuItemByParentId(Long parentId);
}
