public class Profession {
    public String profession;
    private String name;

    public Profession() {
    }

    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return this.name;
    }
}