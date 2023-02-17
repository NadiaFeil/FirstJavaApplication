package movies.managment.moviesManagment.controller;

import movies.managment.moviesManagment.model.Movie;
import movies.managment.moviesManagment.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/all")
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping(path = "/addNew")
    public void postMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
    }

    @DeleteMapping(path = "/delete{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        movieService.delete(movieId);
    }

    @PutMapping(path = "/update/{movieId}")
    public void updateMovie(
            @PathVariable("movieId") Long movieId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false)LocalDate dateAppearance,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String mainActor,
            @RequestParam(required = false) String description
    )
    {
        movieService.update(movieId, name, dateAppearance, type, mainActor, description);
    };

}
