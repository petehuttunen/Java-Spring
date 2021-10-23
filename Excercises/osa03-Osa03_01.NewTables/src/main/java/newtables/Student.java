package newtables;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Pete
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends AbstractPersistable<Long> {

    private String firstName;
    private String lastName;
    
    @JoinTable(
        name="Enrollment",
        joinColumns = @JoinColumn(name="student_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="course_id", referencedColumnName = "id")
    )
    @ManyToMany
    private List<Course> kurssit;
}
