package version1.weather;

import java.util.Observable;

public interface Observer {

    void update(Observable o, Object args);
}
