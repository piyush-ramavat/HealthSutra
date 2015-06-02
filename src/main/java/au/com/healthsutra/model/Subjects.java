package au.com.healthsutra.model;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subjects extends AbstractTimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String position;
    private boolean visible;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Subjects))
            return false;

        Subjects other = (Subjects) obj;
        if (id != other.id)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Subject [id=" + id + ", name=" + name + ", position=" + position + ", visible=" + visible + "]";
    }

}
