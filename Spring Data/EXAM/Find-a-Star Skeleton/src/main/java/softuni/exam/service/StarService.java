package softuni.exam.service;

import softuni.exam.models.entity.Star;

import java.io.IOException;
import java.util.Optional;


public interface StarService {

    boolean areImported();

    String readStarsFileContent() throws IOException;
	
	String importStars() throws IOException;

    String exportStars();

    Optional<Star> findById(Long observingStar);
}
