package online.doordrop.kenya.DoorDrop.store.repository;

import online.doordrop.kenya.DoorDrop.store.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("SELECT g FROM Store g  WHERE g.id = :id")
    Optional<Store> getStoreById(@Param("id") Long id);

    @Query("SELECT g FROM Store g WHERE g.category.storeCategoryId = :storeCategoryId")
    Optional<List<Store>> getStoreByCategory(@Param("storeCategoryId")long storeCategoryId);

}
