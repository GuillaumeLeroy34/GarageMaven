package garages;

import java.util.Objects;

public class Garage {

	private String name;

	public Garage(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (null == name) {
			throw new IllegalArgumentException("name is null");
		}

		this.name = name;
	}

	@Override
	public String toString() {
		return "Garage " + name;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Garage other = (Garage) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
