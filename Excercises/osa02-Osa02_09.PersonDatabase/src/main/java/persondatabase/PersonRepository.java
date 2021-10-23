/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persondatabase;

import persondatabase.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Pete
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
