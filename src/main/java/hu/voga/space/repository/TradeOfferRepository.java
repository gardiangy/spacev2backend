package hu.voga.space.repository;

import hu.voga.space.entity.TradeOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeOfferRepository extends JpaRepository<TradeOffer, Long> {

}
