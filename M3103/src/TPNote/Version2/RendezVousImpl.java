package TPNote.Version2;

import myrendezvous.Rendezvous;

import java.util.Calendar;
import java.util.UUID;

public class RendezVousImpl implements Rendezvous, Cloneable{
    private String description;
    private String title;
    private int duration;
    private Calendar time;
    private UUID tag;

    public RendezVousImpl(String description, String title, int duration, Calendar time) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.time = (Calendar) time.clone();
        this.tag = UUID.randomUUID();
    }

    public RendezVousImpl(String title, int duration, Calendar time) {
        this.description = null;
        this.title = title;
        this.duration = duration;
        this.time = time;
    }

    @Override
    public Calendar getTime() {
        return time;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public UUID getTag() {
        return tag;
    }

    @Override
    public void setTime(Calendar calendar) throws IllegalArgumentException {
        this.time = calendar;
    }

    @Override
    public void setDuration(int i) throws IllegalArgumentException {
        this.duration = i;
    }

    @Override
    public void setTitle(String s) throws IllegalArgumentException {
        this.title = s;
    }

    @Override
    public void setDescription(String s) {
        this.description = s;
    }

    @Override
    public RendezVousImpl clone() {
        try {
            return (RendezVousImpl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
