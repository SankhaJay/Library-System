package middleware.library.LibrarySystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import middleware.library.LibrarySystem.entity.Administrator;
import middleware.library.LibrarySystem.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
    private AdminRepository adminRepository;

    public Administrator addAdmin(Administrator admin) throws Exception {
        System.out.println(admin);
        return adminRepository.save(admin);
    }

    public List<Administrator> getAllAdmins() throws Exception {
        return adminRepository.findAll();
    }

    public Administrator getAdminById(int id) throws Exception {
        return adminRepository.findById(id).orElse(null);
    }

    public List<Administrator> getAdminByName(String name) throws Exception {
        return adminRepository.findByName(name);
    }

    public String deleteAdmin(int id) throws Exception {
        adminRepository.deleteById(id);
        return "Admin removed with ID : " + id;
    }

    public Administrator updateAdmin(Administrator admin) throws Exception {
    	System.out.println("in update admin service");
        System.out.println(admin.getaId());
        Administrator admin1 = adminRepository.findById(admin.getaId()).orElse(null);
        admin1.setName(admin.getName());
        admin1.setAddress(admin.getAddress());
        admin1.setEmail(admin.getEmail());
        admin1.setDob(admin.getDob());
        return adminRepository.save(admin1);
    }

}
