/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.security;

import org.muhia.app.psi.config.security.properties.UserAccountStatus;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Service(value = "psiCustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final IPrincipalsService service;

    private final UserAccountStatus accountStatus;

    @Autowired
    public CustomUserDetailsService(IPrincipalsService service, UserAccountStatus accountStatus) {
        this.service = service;
        this.accountStatus = accountStatus;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final Principals user = service.findByLoginName(email);
        //Logger.getLogger(CustomUserDetailsService.class.getName()).info(String.format("Looking for : %s",email));
//        return User(user.getLoginName(), user.getCredentials(), true, true, true, true, getAuthorities(ROLE_USER));
        /*
          DONE: All boolean values to be replaced by actual flags on
          UserProfiles probably need to create a new Class on top of the model
          Parameters: username - the username presented to the
          DaoAuthenticationProvider password - the password that should be
          presented to the DaoAuthenticationProvider enabled - set to true if
          the user is enabled accountNonExpired - set to true if the account
          has not expired credentialsNonExpired - set to true if the
          credentials have not expired accountNonLocked - set to true if the
          account is not locked authorities - the authorities that should be
          granted to the caller if they presented the correct username and
          password and the user is enabled. Not null.

          Throws: IllegalArgumentException - if a null value was passed either
          as a parameter or as an element in the GrantedAuthority collection

         */
        try {
//            return new User(user.getLoginName(), user.getCredentials(), true, true, true, true, getAuthorities(ROLE_USER));
            /*
              Based on Principals.status 0: Disabled 1: Enabled 5:
              AccountExpired 6: CredentialsExpired 7: AccountsLocked
             */
//            return new User(user.getLoginName(), user.getCredentials(), user.getStatus() == accountStatus.getEnabled(), user.getStatus() != accountStatus.getAccountExpired(), user.getStatus() != accountStatus.getAccountsLocked(), user.getStatus() != accountStatus.getCredentialsExpired(), getGrantedAuthorities(user));
            return new User(user.getLoginName(), user.getCredentials(), user.getStatus() == accountStatus.getEnabled(), user.getStatus() != accountStatus.getAccountExpired(), user.getStatus() != accountStatus.getAccountsLocked(), user.getStatus() != accountStatus.getCredentialsExpired(), user.getGrantedAuthorities());
        } catch (LockedException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage());
            throw new LockedException("Account Locked.");
        } catch (BadCredentialsException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage());
            throw new LockedException("Account Username and/or Password is not recognized.");
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());

        }
    }

    /*
      DONE: Implement DB Based Roles
     */
//    private Collection<GrantedAuthority> getGrantedAuthorities(Principals user) {
//        final Collection<GrantedAuthority> authorities = new ArrayList<>();
////        Collection<UserRoles> userRoleses = new ArrayList<>();
//        service.findUserRolesByUserid(user).ifPresent(rr -> rr.forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getRoleid().getRolename()))));
////        if (service.findUserRolesByUserid(user).isPresent()) {
////            service.findUserRolesByUserid(user).get().stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleid().getRolename())));
////        }
//        return authorities;
//    }

}
