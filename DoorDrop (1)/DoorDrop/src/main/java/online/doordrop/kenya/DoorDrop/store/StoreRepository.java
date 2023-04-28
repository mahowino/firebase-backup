package online.doordrop.kenya.DoorDrop.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("SELECT g FROM Store g  WHERE g.id = :id")
    Optional<Store> getGoodById(@Param("id") Long id);
}
