package Guitar;

public class MandolinSpec extends InstrumentSpec {
    private Style style;
    public MandolinSpec(Builder builder, String model, Type type, Style style, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    @Override
    public boolean matches(InstrumentSpec searchInstrument) {
        if(!(searchInstrument instanceof MandolinSpec)) {
            return false;
        }
        MandolinSpec specs = (MandolinSpec) searchInstrument;

        if(specs.style != null && style != specs.style) return false;

        return super.matches(searchInstrument);
    }
}
