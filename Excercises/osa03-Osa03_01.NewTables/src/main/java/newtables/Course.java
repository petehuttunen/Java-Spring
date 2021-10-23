package newtables;

import java.util.List;
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
public class Course extends AbstractPersistable<Long> {

    private String name;
    @ManyToMany(mappedBy = "kurssit")    
    private List<Student> students;
}
