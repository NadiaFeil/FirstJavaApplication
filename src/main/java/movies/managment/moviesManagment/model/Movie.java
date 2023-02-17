package movies.managment.moviesManagment.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movieSequence",
            sequenceName = "movieSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movieSequence"
    )
    private Long id;
    private String name;
    private LocalDate dateAppearance;
    private String type;
    private String mainActor;
    private String description;

    public Movie() {
    }

    public Movie(Long id, String name, LocalDate dateAppearance, String type, String mainActor, String description) {
        this.id = id;
        this.name = name;
        this.dateAppearance = dateAppearance;
        this.type = type;
        this.mainActor = mainActor;
        this.description = description;
    }

    public Movie(String name, LocalDate dateAppearance, String type, String mainActor, String description) {
        this.name = name;
        this.dateAppearance = dateAppearance;
        this.type = type;
        this.mainActor = mainActor;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateAppearance() {
        return dateAppearance;
    }

    public void setDateAppearance(LocalDate dateAppearance) {
        this.dateAppearance = dateAppearance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateAppearance=" + dateAppearance +
                ", type='" + type + '\'' +
                ", mainActor='" + mainActor + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

