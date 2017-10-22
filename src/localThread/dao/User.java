package localThread.dao;

import lombok.Getter;
import lombok.Setter;

public class User {
	@Getter@Setter
	private Long id;
	@Getter@Setter
	public String name;
	@Getter@Setter
	public Integer age;
}
