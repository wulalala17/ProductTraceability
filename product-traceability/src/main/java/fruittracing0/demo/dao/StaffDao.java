package fruittracing0.demo.dao;

import fruittracing0.demo.StaffPO.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StaffDao extends JpaRepository<Staff,Integer> {
    List<Staff> findByName(String name);
    Optional<Staff> findById(Integer id);
    /*Optional<Staff> findById(Integer id);*/
    @Query(value = "select id,name,sex from new_staff",nativeQuery = true)
    List<Map<String,Object>> findAllCategories();
}
