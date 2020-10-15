package middleware.library.LibrarySystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import middleware.library.LibrarySystem.entity.Admin;
import middleware.library.LibrarySystem.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
    private AdminRepository adminRepository;

    public Admin addAdmin(Admin admin) throws Exception {
        System.out.println(admin);
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() throws Exception {
        return adminRepository.findAll();
    }

    public Admin getAdminById(int id) throws Exception {
        return adminRepository.findById(id).orElse(null);
    }

    public List<Admin> getAdminByName(String name) throws Exception {
        return adminRepository.findByName(name);
    }

    public String deleteAdmin(int id) throws Exception {
        adminRepository.deleteById(id);
        return "Admin removed with ID : " + id;
    }

    public Admin updateAdmin(Admin admin) throws Exception {
    	System.out.println("in update admin service");
        System.out.println(admin.getAdminId());
        Admin admin1 = adminRepository.findById(admin.getAdminId()).orElse(null);
        admin1.setName(admin.getName());
        admin1.setAddress(admin.getAddress());
        admin1.setEmail(admin.getEmail());
        admin1.setDob(admin.getDob());
        return adminRepository.save(admin1);
    }

}
