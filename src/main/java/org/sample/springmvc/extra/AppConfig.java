package org.sample.springmvc.extra;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class AppConfig {

    @Bean(name="messageSource")
    public MessageSource setMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        /*
         *      <value>classpath:i18n/global</value>
         *      <value>classpath:i18n/org/sample/springmvc/extra/ExtraTest2</value>
         *      <value>classpath:i18n/validation/ValidationMessages</value>
         */
        messageSource.setBasenames("i18n/global", "i18n/org/sample/springmvc/extra/ExtraTest2", "i18n/validation/ValidationMessages");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }    
}
