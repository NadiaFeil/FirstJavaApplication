package movies.managment.moviesManagment.configuration;

import movies.managment.moviesManagment.model.Movie;
import movies.managment.moviesManagment.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class MovieConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository repository){
        return args -> {
            Movie film1 = new Movie("film1",
                    LocalDate.of(2002, Month.JULY,1),
                    "tip1",
                    "actor1",
                    "descriere1");

            Movie film2 = new Movie("film2",
                    LocalDate.of(2002, Month.JULY,1),
                    "tip2",
                    "actor2",
                    "descriere2");

            Movie film3 = new Movie("film3",
                    LocalDate.of(2002, Month.JULY,1),
                    "tip3",
                    "actor3",
                    "descriere3");


            repository.saveAll(
                    List.of(film1, film2, film3)
            );
        };
    }
}

