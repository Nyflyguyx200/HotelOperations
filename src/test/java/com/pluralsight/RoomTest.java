package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @org.junit.jupiter.api.Test
    void checkIn_should_Set_Room_Occupied_And_Dirty() {
        //Arrange
        Room room = new Room(2, 100.0);

        //Act
        boolean result = room.checkIn();

        //Assert
        assertTrue(result);
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @org.junit.jupiter.api.Test
    void checkOut_should_Set_Room_Not_Occupied() {
        //Arrange
        Room room = new Room(2, 100.0);
        room.checkIn();

        //Act
        room.checkOut();

        //Assert
        assertFalse(room.isOccupied());
    }

    @org.junit.jupiter.api.Test
    void checkOut_should_Set_Room_Not_Dirty() {
        //Arrange
        Room room = new Room(2, 100.0);
        room.checkIn();

        //Act
        room.cleanRoom();

        //Assert
        assertFalse(room.isDirty());
    }
}
