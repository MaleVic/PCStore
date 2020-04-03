package com.example.PCStore;

import com.example.PCStore.model.MyUserDetails;
import com.example.PCStore.model.User;
import com.example.PCStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
         Optional<User> user = userRepository.findByUserName(userName);
         user.orElseThrow(() -> new UsernameNotFoundException("Не найден: " + userName));
         return user.map(MyUserDetails::new).get();
    }
}
