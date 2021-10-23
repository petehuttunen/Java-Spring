package airports;

import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.springframework.test.context.ActiveProfiles;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class AirportServiceTest {
    
    @Autowired
    AirportService airportService;
    
    @Autowired
    AirportRepository airportRepository;
    
    @Test
    public void canCreateTest() throws Exception{
        Airport a = new Airport();
        a.setIdentifier("KUO");
        a.setName("Kuopio");
        airportRepository.save(a);
        
        airportService.create(a.getIdentifier(), a.getName());
        
        assertTrue(airportRepository.findAll().contains(a));
    }
    
    @Test
    public void canListAirports() throws Exception{
        Airport a = new Airport();
        a.setIdentifier("KUO");
        a.setName("Kuopio");
        
        Airport b = new Airport();
        b.setIdentifier("HEL");
        b.setName("Helsinki");
        
        Airport c = new Airport();
        c.setIdentifier("BER");
        c.setName("Berlin");
        
        airportRepository.save(a);
        airportRepository.save(b);
        airportRepository.save(c);
        
        airportService.create(a.getIdentifier(), a.getName());
        airportService.create(b.getIdentifier(), b.getName());
        airportService.create(c.getIdentifier(), c.getName());
        
        assertEquals(3, airportRepository.findAll().size());
        
    }
    
    @Test
    public void NoDuplicateAirports() throws Exception{
        Airport a = new Airport();
        a.setIdentifier("KUO");
        a.setName("Kuopio");
        
        airportService.create(a.getIdentifier(), a.getName());
        airportService.create(a.getIdentifier(), a.getName());
        
        assertEquals(1, airportRepository.findAll().size());
        
    }
    
}
