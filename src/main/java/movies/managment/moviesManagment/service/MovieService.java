package movies.managment.moviesManagment.service;

import jakarta.transaction.Transactional;
import movies.managment.moviesManagment.model.Movie;
import movies.managment.moviesManagment.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByName(movie.getName());
        if(movieOptional.isPresent()){
            throw new IllegalStateException("This name already exist!");
        }
        movieRepository.save(movie);
    }

    public void delete(Long movieId) {
        if(!movieRepository.existsById(movieId)){
            throw new IllegalStateException("This Id does not exist!");
        }
        movieRepository.deleteById(movieId);
    }

    @Transactional
    public void update(Long movieId, String name, LocalDate dateAppearance, String type, String mainActor, String description) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new IllegalStateException("The movie with this ID does not exist!"));

        if(name != null && name.length() > 0 && !name.equals(movie.getName())){
            Optional<Movie> optionalMovie = movieRepository.findMovieByName(name);
            if(optionalMovie.isPresent()){
                throw new IllegalStateException("This name already exist!");
            }
            movie.setName(name);
        }

        if(dateAppearance != null){
            movie.setDateAppearance(dateAppearance);
        }
        if(type != null && type.length() > 0 && type.equals(movie.getType())){
            movie.setType(type);
        }
        if(mainActor != null && mainActor.length() > 0 && mainActor.equals(movie.getName())){
            movie.setMainActor(mainActor);
        }
        if(description != null && description.length() > 0 && description.equals(movie.getName())){
            movie.setDescription(description);
        }
    }
}
