package airports;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.assertTrue;
import org.springframework.test.web.servlet.MvcResult;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AircraftControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private AircraftRepository aircraftRepository;
    
    @Test
    public void statusOk() throws Exception {
        mockMvc.perform(get("/aircrafts"))
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("aircrafts"))
        .andExpect(model().attributeExists("airports"));
    }
    
    @Test
    public void canPost() throws Exception {
        mockMvc.perform(post("/aircrafts")
                .param("name", "HA-LOL"))
                .andExpect(status().is3xxRedirection());
        
        List<Aircraft> aircrafts = this.aircraftRepository.findAll();
        
        boolean isInDb = aircrafts.stream().anyMatch(craft -> craft.getName().equals("HA-LOL"));
        
        assertTrue(isInDb);
    }
    
    @Test
    public void canFindAircraft() throws Exception {
        mockMvc.perform(post("/aircrafts")
                .param("name", "XP-55"))
                .andExpect(redirectedUrl("/aircrafts"))
                .andExpect(status().is3xxRedirection());
        
        MvcResult result = mockMvc.perform(get("/aircrafts"))
                                   .andReturn();
        List<Aircraft> aircrafts = (List) result.getModelAndView().getModel().get("aircrafts");
        boolean isInModel = aircrafts.stream().anyMatch(craft -> craft.getName().equals("XP-55"));
        assertTrue(isInModel);
                
    }
    
}
