package com.example.sms.repository;

import com.example.sms.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value="SELECT * FROM admins admin WHERE admin.email=:adminEmail and admin.password=:adminPassword", nativeQuery=true)
    Admin findByEmail(@Param("adminEmail") String adminEmail,@Param("adminPassword") String adminPassword);
}
