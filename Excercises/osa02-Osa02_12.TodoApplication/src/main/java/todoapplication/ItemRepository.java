/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapplication;

import org.springframework.data.jpa.repository.JpaRepository;
import todoapplication.Item;
/**
 *
 * @author Pete
 */
public interface ItemRepository extends JpaRepository<Item, Integer>{
    
}
