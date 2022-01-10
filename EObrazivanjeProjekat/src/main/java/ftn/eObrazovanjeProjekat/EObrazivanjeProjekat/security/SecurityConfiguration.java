package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	

	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}

	@Autowired
	public void configureAuthentication(
			AuthenticationManagerBuilder auth)
			throws Exception {
				auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean()
			throws Exception {
		AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
		authenticationTokenFilter
				.setAuthenticationManager(authenticationManagerBean());
		return authenticationTokenFilter;
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.csrf().disable().cors().disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.authorizeRequests()
				.antMatchers("/index.html", "/api/users/login", "/api/logOut", "/api/signup").permitAll() //, "/api/register"
//				.antMatchers(HttpMethod.POST, "/api/**")
//					.hasAuthority("ROLE_ADMINISTRATOR") //only administrator can add and edit data
				.anyRequest().authenticated();
				 
		
		// Custom JWT based authentication
		httpSecurity.addFilterBefore(authenticationTokenFilterBean(),
				UsernamePasswordAuthenticationFilter.class);
	}


//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity
//			.csrf().disable()
//			.sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and()
//			.authorizeRequests()
//				.antMatchers("/index.html", "/api/users/login", "/styles.css", "/profile", 
//						
//                        "/runtime.js", "/polyfills.js", "/vendor.js", "/main.js", "/images/**", "/js/**",
//                        "/runtime-es2015.js", "/polyfills-es2015.js", "/vendor-es2015.js", "/main-es2015.js").permitAll()
//
////				.antMatchers(HttpMethod.POST, "/api/admin/**")
////					.hasAuthority("ROLE_ADMIN") //only administrator can add and edit data
//				.anyRequest().authenticated();
//
//		
//		// Custom JWT based authentication
//		httpSecurity.addFilterBefore(authenticationTokenFilterBean(),
//				UsernamePasswordAuthenticationFilter.class);
//	}
}

