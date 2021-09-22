package Guitar;

public abstract class InstrumentSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public boolean matches(InstrumentSpec instrumentSpec) {
        if (instrumentSpec.backWood!=null && backWood != instrumentSpec.backWood) return false;
        if (instrumentSpec.builder!=null && builder != instrumentSpec.builder) return false;
        if ((instrumentSpec.model != null) && (!instrumentSpec.model.equals("")) && (!model.equalsIgnoreCase(instrumentSpec.getModel()))) return false;
        if (instrumentSpec.topWood!=null &&topWood != instrumentSpec.topWood) return false;
        if (instrumentSpec.type!=null && type != instrumentSpec.type) return false;

        return true;
    }
}
