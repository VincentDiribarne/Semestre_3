package Guitar;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final ArrayList<Instrument> instruments;

    public Inventory() {
        instruments = new ArrayList<>();
    }

    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    public Instrument getInstrument(String serialNumber) {
        for (Instrument instrument : instruments) {
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List<Instrument> search(InstrumentSpec searchInstrumentSpec) {
        List<Instrument> matchingInstrument = new ArrayList<>();

        for (Instrument instrument : instruments) {
            if(instrument.getInstrumentSpec().matches(searchInstrumentSpec)) {
                matchingInstrument.add(instrument);
            }
        }

        return matchingInstrument;
    }


}
