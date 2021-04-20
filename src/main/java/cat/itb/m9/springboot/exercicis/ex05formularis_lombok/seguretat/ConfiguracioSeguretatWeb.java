package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.seguretat;

import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.servei.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracioSeguretatWeb extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/login","/register/**","/error","/",  "/registre","/empleats/listOrdenatEmail","/empleats/directius","/loginerror").permitAll()
                .antMatchers("/empleats/edit/**","/empleats/new/submit","/empleats/modificar/**","/empleats/list").authenticated()
                .antMatchers("/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/loginerror")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
                //no va  el failure url porque al subirlo al postgres te  cambia la ruta y no  es con el / no  encuentra la  ruta

    }
}
