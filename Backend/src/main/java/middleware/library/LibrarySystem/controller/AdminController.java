package middleware.library.LibrarySystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import middleware.library.LibrarySystem.entity.Admin;
import middleware.library.LibrarySystem.service.AdminService;

@RestController()
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    private AdminService adminService;
    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) throws Exception{
        System.out.println(admin);
        return adminService.addAdmin(admin);
    }
    
    @GetMapping("/admins")
    public List<Admin> getAllAdmins() throws Exception{
        return adminService.getAllAdmins();
    }

    @GetMapping("/getAdminById/{id}")
    public Admin getAdminById(@PathVariable String id) throws Exception{
        return adminService.getAdminById(Integer.parseInt(id));
    }

    @GetMapping("/getAdminByName/{name}")
    public List<Admin> getAdminByName(@PathVariable String name) throws Exception{
        return adminService.getAdminByName(name);
    }

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin) throws Exception{
        System.out.println("Updating " + admin);
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable int id) throws Exception{
        return adminService.deleteAdmin(id);
    }

}
 