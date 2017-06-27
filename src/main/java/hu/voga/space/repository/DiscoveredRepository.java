package hu.voga.space.repository;

import hu.voga.space.entity.Discovered;
import hu.voga.space.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscoveredRepository extends JpaRepository<Discovered, Long> {

    List<Discovered> findByUser(User user);
}
