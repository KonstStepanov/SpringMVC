package tacos;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;

	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = new Random().nextLong(1,1000);

	private Date createdAt = new Date(System.currentTimeMillis());
}
