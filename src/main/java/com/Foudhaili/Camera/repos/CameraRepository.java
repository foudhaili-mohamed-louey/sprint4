package com.Foudhaili.Camera.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.Models.Lens;

@RepositoryRestResource(path = "rest") 
public interface CameraRepository extends JpaRepository<Camera , Integer> {
	
	List<Camera> findByName(String name);
	List<Camera> findByNameContains(String name);
	
	@Query("select c from Camera c where c.type like %?1 and c.resolution > ?2")
	List<Camera> findByTypeAndResolution(@Param("type") String type,@Param("resolution") Long resolution);
	
	@Query("select c from Camera c where c.lens = ?1")
	List<Camera> findByLens(Lens lens);
	
	List<Camera> findByLens_IdLens(int idLens);
	
	List<Camera> findByOrderByNameAsc();

}
