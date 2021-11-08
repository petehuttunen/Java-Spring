package weatherservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Pete
 */
@Service
public class LocationService {
        
    @Autowired
    LocationRepository locationRepository;
    
    @Cacheable("locations")
    public Location oneLocation(Long id) {
        return locationRepository.getOne(id);
    }
    
    @Cacheable("locations")
    public List<Location> allLocations() {
        return locationRepository.findAll();
    }
    
    @CacheEvict(cacheNames="locations", allEntries = true)
    public void flushCache() {
    }
    
    @CacheEvict(cacheNames = "locations", allEntries = true)
    @PostMapping("/locations")
    public Location addLocation(@ModelAttribute Location location) {
        return locationRepository.save(location);
    }
    
}
    

