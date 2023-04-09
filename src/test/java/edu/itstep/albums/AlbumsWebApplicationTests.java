package edu.itstep.albums;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import edu.itstep.albums.controllers.PersonController;

@SpringBootTest
class AlbumsWebApplicationTests {
  @Autowired
  private PersonController personController;
	@Test
	void contextLoads() {
		assertThat(personController).isNotNull();
	}

}
