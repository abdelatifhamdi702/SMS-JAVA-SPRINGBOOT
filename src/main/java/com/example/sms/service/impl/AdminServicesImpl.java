package com.example.sms.service.impl;

import com.example.sms.entity.Admin;
import com.example.sms.repository.AdminRepository;
import com.example.sms.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;

import javax.persistence.Column;

@Service
public class AdminServicesImpl implements AdminServices {

    private AdminRepository adminRepository;

    @Autowired
    public AdminServicesImpl(AdminRepository adminRepository) {
        super();
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminByEmail(String email, String password) {
        return adminRepository.findByEmail(email,password);
    }
}
