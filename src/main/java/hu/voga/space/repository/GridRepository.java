package hu.voga.space.repository;


import hu.voga.space.entity.Grid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GridRepository extends JpaRepository<Grid, Long> {

    @Query(value = "select g.grid_id from grid g order by abs(g.grid_x - ?1) asc, abs(g.grid_y - ?2) asc limit 1", nativeQuery = true)
    Object[] findNearestGrid(int x, int y);



}
