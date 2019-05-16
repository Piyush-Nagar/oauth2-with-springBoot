import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.piyush.resourceserver.security.Member;
import com.piyush.resourceserver.security.UserDetailImpl;

@SpringBootApplication
@ComponentScan(value = "com.piyush")
public class Application {

  public static void main(String[] args) throws Exception{
    new SpringApplicationBuilder(Application.class).run(args);
  }

  @Autowired
  public void authenticationManager(AuthenticationManagerBuilder builder, UserDetailsService userDetailsService) {
    try {
      Member member = new Member();
      member.setUserName("piyush");
      member.setPassword("1234567890");
      UserDetailImpl userDetail = new UserDetailImpl(member);
      builder.userDetailsService(x -> userDetail);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
