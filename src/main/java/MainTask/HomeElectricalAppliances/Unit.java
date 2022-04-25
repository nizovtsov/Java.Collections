package MainTask.HomeElectricalAppliances;

public class Unit {
    private static int unitIdCounter = 1;
    private int unitId;
    private String unitName;
    private Room room;
    private int unitPower;
    private boolean isPowerOn;

    public Unit(String unitName, Room room, int unitPower) {
        unitId = unitIdCounter++;
        this.unitName = unitName;
        this.room = room;
        this.unitPower = unitPower;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getUnitPower() {
        return unitPower;
    }

    public void setUnitPower(int unitPower) {
        this.unitPower = unitPower;
    }

    public void removeRoomFromUnit() {
        room = null;
    }

    public void powerOnUnit() {
        this.isPowerOn = true;
    }

    public void powerOffUnit() {
        this.isPowerOn = false;
    }

    public boolean isUnitPoweredON() {
        return isPowerOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (unitIdCounter != unit.unitIdCounter) return false;
        if (unitId != unit.unitId) return false;
        if (unitPower != unit.unitPower) return false;
        if (isPowerOn != unit.isPowerOn) return false;
        if (unitName != null ? !unitName.equals(unit.unitName) : unit.unitName != null) return false;
        return room != null ? room.equals(unit.room) : unit.room == null;
    }

    @Override
    public int hashCode() {
        int result = unitIdCounter;
        result = 31 * result + unitId;
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + unitPower;
        result = 31 * result + (isPowerOn ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitId=" + unitId +
                ", unitName='" + unitName + '\'' +
                ", room=" + room +
                ", unitPower=" + unitPower +
                ", isPowerOn=" + isPowerOn +
                '}';
    }
}
