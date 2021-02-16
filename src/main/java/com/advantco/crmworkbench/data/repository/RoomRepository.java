package com.advantco.crmworkbench.data.repository;

import com.advantco.crmworkbench.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository  extends CrudRepository<Room, Long> {
}
