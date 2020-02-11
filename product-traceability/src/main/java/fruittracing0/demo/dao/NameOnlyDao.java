package fruittracing0.demo.dao;

import fruittracing0.demo.StaffPO.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NameOnlyDao extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff>{
    //StaffNameOnly findById(Integer id);
}
