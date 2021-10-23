package todoapplication;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 *
 * @author Pete
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item extends AbstractPersistable<Integer>{
    
    private String name;
    private Integer checked;
    
}
