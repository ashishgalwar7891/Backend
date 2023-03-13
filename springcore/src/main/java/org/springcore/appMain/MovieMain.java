package org.springcore.appMain;

import org.springcore.config.MovieConfig;
import org.springcore.domain.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MovieMain {
    public static void main(String[] args){
        ApplicationContext context=new AnnotationConfigApplicationContext(MovieConfig.class);
        Movie obj= (Movie) context.getBean("MovieBean2");
        System.out.println(obj);

        Movie m1=context.getBean("MovieBean1", Movie.class);
        System.out.println(m1);
    }
}
