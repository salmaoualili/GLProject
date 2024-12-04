package Mp.example.demoM.services;

import Mp.example.demoM.Entities.Admin;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public abstract class Admindetailsserv {
    protected static UserDetails build(Admin admin) {
        return null;
    }

    @Transactional
    public abstract UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
