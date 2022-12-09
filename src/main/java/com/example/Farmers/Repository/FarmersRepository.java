package com.example.Farmers.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.Farmers.Entity.Farmers;

@Repository
public interface FarmersRepository extends JpaRepository<Farmers, Integer>{
//	 List<Researchers> findByPublished(boolean published);
//	  List<Researchers> findByTitleContaining(String name);
	List<Farmers>findByEmail(String email);
	

}
