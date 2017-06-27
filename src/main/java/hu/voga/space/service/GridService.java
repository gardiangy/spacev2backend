package hu.voga.space.service;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import hu.voga.space.dto.GridDto;
import hu.voga.space.dto.converter.GridConverter;
import hu.voga.space.entity.Grid;
import hu.voga.space.entity.QGrid;
import hu.voga.space.entity.QSolarSystem;
import hu.voga.space.repository.GridRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the Grid Service.
 */
@Service
public class GridService {

    private static final Logger logger = LoggerFactory.getLogger(GridService.class);

    @Autowired
    private GridRepository gridRepository;

    @Autowired
    private GridConverter gridConverter;

    @Autowired
    private EntityManager entityManager;

    public Grid save(Grid grid) {
        return gridRepository.save(grid);
    }

    public void deleteAll() {
        gridRepository.deleteAll();
    }

    public List<Grid> findAll() {
        return gridRepository.findAll();
    }

    public List<GridDto> findAllForStarMap() {
        JPAQuery<Grid> query = new JPAQuery<>(entityManager);
        List<Tuple> fetch = query.select(QGrid.grid, QSolarSystem.solarSystem)
                .from(QGrid.grid)
                .leftJoin(QGrid.grid.solarSystem, QSolarSystem.solarSystem)
                .fetch();

        return fetch.stream()
                .map(tuple -> gridConverter.convertToDto(tuple.get(QGrid.grid)))
                .collect(Collectors.toList());
    }

    public Optional<Grid> findNearestGrid(int x, int y) {
        Object[] nearestGrid = gridRepository.findNearestGrid(x, y);
        return gridRepository.findById((Long) nearestGrid[0]);
    }

    public void generateGrid() {
        gridRepository.deleteAll();
        int x = 60;
        int y = 60;
        List<Grid> grids = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Grid grid = new Grid();
                grid.setGridX(x);
                grid.setGridY(y);
                grids.add(grid);
                y += 120;
            }
            y = 60;
            x += 120;
        }
        gridRepository.saveAll(grids);
    }


}
