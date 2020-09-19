package lk.joinus.jobportal.main;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration
//@ComponentScan("lk.ijse.jobportal")
//@EnableWebMvc
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
//@EnableTransactionManagement
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
