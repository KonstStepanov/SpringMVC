package tacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;

@SpringBootTest
public class JDBC_TEST {
	@Mock
	JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBC_TEST(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Test
	public void whenMockJdbcTemplate_thenReturnIngredientCount() {
		Mockito.when(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM INGREDIENT", Integer.class)).thenReturn(15);

		Assertions.assertEquals(15, jdbcTemplate.queryForObject("SELECT COUNT(*) FROM INGREDIENT", Integer.class));
	}
}
