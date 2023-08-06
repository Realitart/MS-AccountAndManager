package com.realitart.accountandmanager.Domain.Repositories;

import com.realitart.accountandmanager.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepostory extends JpaRepository<User, Long> {
//    @Query(nativeQuery = true, value = "select pl.id, pl.campus_id, pl.name, pl.aforo , " +
//            "pl.aforo - (select count(pr.id) " +
//            " from parking_reservation pr " +
//            " where pr.parking_lot_id=pl.id " +
//            " and pr.reservationdate = ?2 and pr.enable=1) as disponibles " +
//            " from parking_lot pl " +
//            " where pl.campus_id = ?1")
//    public Optional<List<IParkingLotByCampusRespDTO>> get_parkinglot_by_campusId(Long campusId, String fecha);
}
