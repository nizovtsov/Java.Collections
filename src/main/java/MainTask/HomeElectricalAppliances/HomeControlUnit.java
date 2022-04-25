package MainTask.HomeElectricalAppliances;

import java.util.ArrayList;

public class HomeControlUnit {
    private ArrayList<Room> rooms;

    public HomeControlUnit() {
        rooms = new ArrayList<>();
    }

    public void addNewRoom(String roomName) {
        if (roomName.isEmpty() || roomName == null) {
            System.out.println("Room name can not be empty or Null");
            return;
        } else if (findRoom(roomName) != null) {
            throw new IllegalArgumentException("Room name already exists");
        } else {
            rooms.add(new Room(roomName));
            System.out.println("Room added");
        }
    }

    private Room findRoom(String roomName) {
        for (Room room : rooms) {
            if (room.getRoomName().equalsIgnoreCase(roomName)) {
                return room;
            }
        }
        return null;
    }

    public void addNewUnit(String unitName, int unitPower, String roomName) {
        if (unitName.isEmpty() || unitName == null) {
            System.out.println("Unit name can not be empty or Null");
            return;
        } else {
            if (unitPower <= 0) {
                System.out.println("Power of unit must be positive");
                return;
            }
        }
        Room room = findRoom(roomName);
        if (room == null) {
            System.out.println("Room not found");
            return;
        }
        Unit unit = new Unit(unitName, room, unitPower);
        room.assignUnitToRoom(unit);
        System.out.println("Unit added");
    }

    public void deleteUnit(int unitId) {
        if (unitId <= 0) {
            System.out.println("Unit index must be positive");
            return;
        }
        for (Room room : rooms) {
            for (Unit unit : room.getRoomUnits()) {
                if (unit.getUnitId() == unitId) {
                    unit.removeRoomFromUnit();
                    room.deleteUnit(unit);
                    System.out.println("Unit removed");
                    return;
                }
            }
        }
        System.out.println("Unit does not exist");
    }

    public void powerOnUnit(int unitId) {
        if (unitId <= 0) {
            System.out.println("Device index must be positive");
            return;
        }
        Unit unit = getOneUnit(unitId);
        if (unit != null) {
            unit.powerOnUnit();
            System.out.println("Unit turned on");
            return;
        } else {
            System.out.println("Unit not found");
        }
    }

    public void powerOffUnit(int unitId) {
        if (unitId <= 0) {
            System.out.println("Device index must be positive");
            return;
        }
        Unit unit = getOneUnit(unitId);
        if (unit != null) {
            unit.powerOffUnit();
            System.out.println("Unit turned off");
            return;
        } else {
            System.out.println("Unit not found");
        }
    }

    private Unit getOneUnit(int unitId) {
        for (Room room : rooms) {
            for (Unit unit : room.getRoomUnits()) {
                if (unit.getUnitId() == unitId) {
                    return unit;
                }
            }
        }
        return null;
    }

    public void printAllUnits() {
        for (Unit unit : getAllUnits()) {
            System.out.println(unit);
        }
    }

    private ArrayList<Unit> getAllUnits() {
        ArrayList<Unit> units = new ArrayList<>();
        for (Room room : rooms) {
            for (Unit unit : room.getRoomUnits()) {
                units.add(unit);
            }
        }
        return units;
    }

    public void printAllSortedUnits() {
        System.out.println("List of units turned on and sorted by power ascending");
        ArrayList<Unit> units = getAllUnits();
        units.sort(new UnitPowerComparator());
        for (Unit unit : units) {
            if (unit.isUnitPoweredON()) {
                System.out.println(unit);
            }
        }
    }

    public void printActualPower() {
        int totalPower = 0;
        ArrayList<Unit> units = getAllUnits();
        for (Unit unit : units) {
            if (unit.isUnitPoweredON()) {
                totalPower += unit.getUnitPower();
            }
        }
        printAllSortedUnits();
        System.out.println("--------------\n" + "Total actual power = " + totalPower + " W");
    }

    public void findUnit(String unitName) {
        ArrayList<Unit> units = getAllUnits();
        System.out.println("Found the following units with a similar name:");
        for (Unit unit : units) {
            if (unit.getUnitName().equalsIgnoreCase(unitName) || unit.getUnitName().contains(unitName)) {
                System.out.println(unit);
            }
        }
    }
}
