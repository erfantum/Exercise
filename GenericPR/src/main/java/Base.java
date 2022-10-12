public class Base {
    private Integer id;

    public Base(Integer id) {
        this.id = id;
    }

    public Base() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                '}';
    }
}