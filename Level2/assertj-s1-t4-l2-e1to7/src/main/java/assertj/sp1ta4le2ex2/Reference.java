package assertj.sp1ta4le2ex2;

public class Reference {
    private int id;
    private String value;

    public Reference(int id, String value) {
        this.id = id;
        this.value = value;
    }

    // Getters i setters (opcionals, per completesa)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Mètode equals sobrescrit per comparar contingut
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Reference other = (Reference) obj;
        return id == other.id && value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return 31 * id + (value != null ? value.hashCode() : 0);
    }
}
