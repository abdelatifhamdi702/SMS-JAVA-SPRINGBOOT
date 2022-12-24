package com.example.sms.service;

import com.example.sms.entity.Admin;

public interface AdminServices {

    Admin saveAdmin(Admin admin);
    Admin getAdminByEmail(String email, String password);
}
