package projectpackage.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectpackage.model.AuthEntities.Role;
import projectpackage.model.AuthEntities.User;
import projectpackage.repositories.AuthRepositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gvozd on 07.01.2017.
 */
@Log4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String s){
        User user = null;
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        try {
            user = userRepository.findByUsername(s);
            for (Role role: user.getRoles()){
                log.warn("AUTHORITY is "+role.toString());
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        } catch (Exception e){
            log.info("***************************************************************************************");
            log.warn("Exception in finding user by username");
            log.warn("Was trying to find user by username: "+s);
            if (user!=null){
                log.warn("Loaded user: "+user.toString());
            } else System.out.println("USER RETURNED: NULL");
            log.warn("Exception message: "+e.getMessage());
            log.warn("Exception stacktrace: "+e.getStackTrace());
            throw new InternalAuthenticationServiceException(e.getMessage(), e);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
