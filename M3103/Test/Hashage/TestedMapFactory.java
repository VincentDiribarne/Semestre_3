package Hashage;

public class TestedMapFactory {
    public static Map<String, String> createOpenAdressMap(int mapSize) {
        return new MapImpl<>(mapSize);
    }

    public static Map<String, String> createExtChainMap(int mapSize) {
        return new MapImpl<>(mapSize);
    }
}
