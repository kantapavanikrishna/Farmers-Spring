package com.example.Farmers.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Farmers.Entity.Farmers;
import com.example.Farmers.Entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

	Login findByUsername(String username);
//	Login findByPassword(String password);
}
