package tietokannat;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import uudelleenohjaus.GetMapping;
import uudelleenohjaus.Model;
import uudelleenohjaus.PostMapping;
import uudelleenohjaus.RequestParam;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Henkilo extends AbstractPersistable<Long> {

    private String nimi;
}