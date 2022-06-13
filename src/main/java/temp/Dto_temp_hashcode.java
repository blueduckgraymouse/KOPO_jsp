package temp;

import java.util.Objects;

public class Dto_temp_hashcode {
	int id;
	String name;
	String addr;
	
	public Dto_temp_hashcode(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Dto_temp [id=" + id + ", name=" + name + ", addr=" + addr + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addr, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dto_temp_hashcode other = (Dto_temp_hashcode) obj;
		return Objects.equals(addr, other.addr) && id == other.id && Objects.equals(name, other.name);
	}
	
	
}
