package kea.exersice.harrypotter003.repository;

import kea.exersice.harrypotter003.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, String> {
}
