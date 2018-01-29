package springAspectDemo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PropertyChangeTracker {
	@Before("execution(@springAspectDemo.TrackChanges * *(..))") //Return type, function name, parameters are wild cards
	public void trackChange() {
		System.out.println("Property changed\n");
	}
}
