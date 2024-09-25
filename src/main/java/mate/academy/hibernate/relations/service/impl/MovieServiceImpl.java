package mate.academy.hibernate.relations.service.impl;

import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;
import mate.academy.hibernate.relations.dao.MovieDao;
import mate.academy.hibernate.relations.model.Movie;
import mate.academy.hibernate.relations.service.MovieService;


public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        Optional<Movie> movie = movieDao.get(id);
        if (movie.isEmpty()) {
            throw new EntityNotFoundException("Movie with id " + id + " not found");
        }
        return movie.get();
    }
}
