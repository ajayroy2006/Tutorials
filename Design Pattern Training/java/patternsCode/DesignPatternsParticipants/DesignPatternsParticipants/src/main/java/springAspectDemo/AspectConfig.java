package springAspectDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

	@Bean
	public Cache myCache() {
		return new SimpleCache();
	}
	
	@Bean
	public PropertyChangeTracker propertyChangeTracker() {
		return new PropertyChangeTracker();
	}
}
