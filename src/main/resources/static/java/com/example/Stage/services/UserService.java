package com.example.Stage.services;

import com.example.Stage.entity.User;
import com.example.Stage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Get All todos
     *
     * @return List<Todo>
     */

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public List<User> search(String value){
        return userRepository.search(value);
    }

    public void delete(int idUser) {
        userRepository.deleteById(idUser);
    }

    public User findBy(int idUser) {
        return userRepository.findById(idUser).get();
    }

    public User save(User user) {
        user.setPassword(passwordEncoder().encode("dddd"));

        return userRepository.save(user);
    }

    public User update(User user, int idUser) {
        User oldUser = userRepository.findById(idUser).get();
        System.out.println(" the old one::::" + oldUser);
        oldUser.setIdUser(user.getIdUser());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setHireDate(user.getHireDate());
        oldUser.setAddress(user.getAddress());
        oldUser.setSex(user.getSex());
        oldUser.setPassword(user.getPassword());
        oldUser.setTel(user.getTel());
        oldUser.setBirthDate(user.getBirthDate());
        oldUser.setDepartment(user.getDepartment());
        System.out.println("the new Titile is::::" + user.getFirstName());
        System.out.println("the new to user" + user);
        userRepository.save(user);
        return user;
    }
















    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);
  throw  new UsernameNotFoundException("User not found");

    }

    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new User("bara", passwordEncoder().encode("000000"));
    }*/


    public void login(String email, String password) {
       if( userRepository.findByEmail("gmail@gmail.com") == null){
           System.out.println("\n there is no user with this email \n");
       }else{
           System.out.println("\n ok there is a user \n");
         User k=  userRepository.findByEmail(email);

           if (k.getPassword() == passwordEncoder().encode("gmail")  ){
               System.out.println("\n password coorect \n");
           }else {
               System.out.println("not okkkkkkkk\n");
           }

       }

    }
}


