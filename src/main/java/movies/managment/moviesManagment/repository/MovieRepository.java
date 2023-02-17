package movies.managment.moviesManagment.repository;

import movies.managment.moviesManagment.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    //@Query("SELECT m FROM Movie m WHERE m.name = ?1")
    Optional<Movie> findMovieByName(String name);
    Optional<Movie> findById(Long id);
}
