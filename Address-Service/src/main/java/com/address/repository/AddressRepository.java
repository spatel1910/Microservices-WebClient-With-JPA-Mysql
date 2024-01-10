package com.address.repository;

import com.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query( value="select ad.id,ad.city,ad.state,ad.emp_id from employee e \n" +
            "inner join \n" +
            "address ad\n" +
            "on\n" +
            "e.id=ad.emp_id where e.id=:id",nativeQuery = true)
    public Address getAddressByEmpId(@Param("id") int id);

}
