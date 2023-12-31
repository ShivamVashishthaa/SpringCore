package com.Dependencies;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//--------------------Field Injection --------------------------------------------------------------------------
//@Component
//class YourBusinessClass{
//	@Autowired
//	Dependency1 dependency1;
//	@Autowired
//	Dependency2 dependency2;
//	@Override
//	public String toString() {
//		return "YourBusinessClass [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
//	}
//}
//------------------------------------------------------------------------------------------------------------	

//--------------------Setter Injection --------------------------------------------------------------------------
//@Component
//class YourBusinessClass{
//	Dependency1 dependency1;
//	Dependency2 dependency2;
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = new Dependency1();
//	}
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = new Dependency2();
//	}
//}
//------------------------------------------------------------------------------------------------------------	

//--------------------Constructor Injection --------------------------------------------------------------------------
@Component
class YourBusinessClass{
	Dependency1 dependency1;
	Dependency2 dependency2;
	
	@Autowired                            // @Autowired is not mandatory and prefer to use this injection
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
}
//------------------------------------------------------------------------------------------------------------	

@Component
class Dependency1{
	
}
@Component
class Dependency2{
	
}
@Configuration
@ComponentScan
public class DependencyInjections {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(DependencyInjections.class))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(YourBusinessClass.class));
		}
		
	}

}
