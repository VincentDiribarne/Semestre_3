package Guitar;

public class GuitarSpec extends InstrumentSpec{
    private final int nbString;
    public static final int NO_PREF_NUM_STRINGS = -1;

    public GuitarSpec(Builder builder, String model, Type type, int nbString, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.nbString = nbString;
    }

    public int getNbString() {
        return nbString;
    }

    @Override
    public boolean matches(InstrumentSpec searchInstrument) {
        if(!(searchInstrument instanceof GuitarSpec)) {
            return false;
        }
        GuitarSpec specs = (GuitarSpec) searchInstrument;

        if(specs.getNbString() != NO_PREF_NUM_STRINGS && specs.getNbString() != getNbString()) {
            return false;
        }

        return super.matches(searchInstrument);
    }
}
