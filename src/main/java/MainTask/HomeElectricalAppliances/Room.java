package MainTask.HomeElectricalAppliances;

import java.util.ArrayList;

public class Room {
    private String roomName;
    private ArrayList<Unit> roomUnits;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ArrayList<Unit> getRoomUnits() {
        return roomUnits;
    }

    public void setRoomUnits(ArrayList<Unit> roomUnits) {
        this.roomUnits = roomUnits;
    }

    public Room(String roomName) {
        if (roomName.isEmpty() || roomName == null) {
            throw new IllegalArgumentException("Room Name can not be Null");
        } else {
            this.roomName = roomName;
            this.roomUnits = new ArrayList<>();
        }
    }

    public void assignUnitToRoom(Unit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit can not be Null");
        }
        if (!checkUnitExists(unit)) {
            roomUnits.add(unit);
        }
    }

    private boolean checkUnitExists(Unit unit) {
        for (Unit tempUnit : roomUnits) {
            if (tempUnit.equals(unit)) {
                return true;
            }
        }
        return false;
    }

    public void deleteUnit(Unit unit){
        if (unit == null) {
            throw new IllegalArgumentException("Unit can not be Null");
        }
        if (checkUnitExists(unit)) {
            roomUnits.remove(unit);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomName != null ? !roomName.equals(room.roomName) : room.roomName != null) return false;
        return roomUnits != null ? roomUnits.equals(room.roomUnits) : room.roomUnits == null;
    }

    @Override
    public int hashCode() {
        int result = roomName != null ? roomName.hashCode() : 0;
        result = 31 * result + (roomUnits != null ? roomUnits.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                '}';
    }
}
