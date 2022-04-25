package MainTask.HomeElectricalAppliances;

import java.util.Comparator;

public class UnitPowerComparator implements Comparator<Unit> {
    @Override
    public int compare(Unit unit, Unit t1) {
        return (unit.getUnitPower() - t1.getUnitPower());
    }
}
