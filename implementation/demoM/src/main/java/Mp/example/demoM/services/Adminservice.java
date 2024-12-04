package Mp.example.demoM.services;

import Mp.example.demoM.Entities.*;
import Mp.example.demoM.repositories.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Adminservice extends Admindetailsserv {
    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin non trouvé avec le nom complet : " + username));

        return Admindetailsserv.build(admin);
    }




}
