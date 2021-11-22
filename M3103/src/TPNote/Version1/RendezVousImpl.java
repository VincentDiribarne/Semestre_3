package TPNote.Version1;

import myrendezvous.Rendezvous;

import java.util.Calendar;

public class RendezVousImpl  implements Rendezvous {
    @Override
    public Calendar getTime() {
        return null;
    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setTime(Calendar calendar) throws IllegalArgumentException {

    }

    @Override
    public void setDuration(int i) throws IllegalArgumentException {

    }

    @Override
    public void setTitle(String s) throws IllegalArgumentException {

    }

    @Override
    public void setDescription(String s) {

    }
}
