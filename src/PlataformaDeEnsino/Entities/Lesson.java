package PlataformaDeEnsino.Entities;

public abstract class Lesson {
    private String title;

    public Lesson(String title) {
        this.title = title;
    }

    public abstract int duration();
}
