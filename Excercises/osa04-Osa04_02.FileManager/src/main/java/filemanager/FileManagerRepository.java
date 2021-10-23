package filemanager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileManagerRepository extends JpaRepository<FileManagerObject, Long> {
    
}
