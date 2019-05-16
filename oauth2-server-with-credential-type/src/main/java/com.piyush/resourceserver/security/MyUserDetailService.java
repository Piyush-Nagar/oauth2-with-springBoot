package com.piyush.resourceserver.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {


  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

    Member member = null;
    if (s.equals("piyush")) {
      member = Member.builder()
          .userName("piyush")
          .password("1234567890")
          .build();
    }

    if (null == member) {
      throw new UsernameNotFoundException("User not found");
    }
    return new UserDetailImpl(member);
  }
}
