package hu.voga.space.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web configurations.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer
{

	@Override
	public final void addCorsMappings(final CorsRegistry registry)
	{
		registry.addMapping("/**")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
	}
}
