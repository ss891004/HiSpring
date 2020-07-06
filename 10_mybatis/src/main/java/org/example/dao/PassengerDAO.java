package org.example.dao;

import org.example.entity.Passenger;
import org.apache.ibatis.annotations.Param;

public interface PassengerDAO {
    Passenger queryPassengerById(@Param("id") Integer id);
}
