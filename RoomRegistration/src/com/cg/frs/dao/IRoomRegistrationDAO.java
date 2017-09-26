package com.cg.frs.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.frs.exception.RoomException;
import com.cg.orb.dto.RoomRegistrationDTO;

public interface IRoomRegistrationDAO {
int registerRoom(RoomRegistrationDTO flat) throws  RoomException;

public ArrayList<Integer> retrieveDetails();
}
