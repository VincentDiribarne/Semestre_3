package TPNote.Version1;

import TPNote.Version1.Exception.RendezVousExistant;
import myrendezvous.Rendezvous;
import myrendezvous.RendezvousManager;
import myrendezvous.exceptions.RendezvousNotFound;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TreeMap;

public class RendezVousManagerImpl implements RendezvousManager {
    TreeMap<Integer, RendezVousImpl> RendezVousManager = new TreeMap<>();

    @Override
    public Rendezvous addRendezvous(Rendezvous rdv) {
        RendezVousImpl rendezVous = new RendezVousImpl(rdv.getTitle(), rdv.getDescription(), rdv.getDuration(), rdv.getTime());
        if (RendezVousManager.containsKey(rendezVous.getTag())) {
            try {
                throw new RendezVousExistant();
            } catch (RendezVousExistant e) {
                e.printStackTrace();
            }
        }
        RendezVousManager.put(rendezVous.getTag(), rendezVous);
        return rendezVous.clone();
    }

    @Override
    public void removeRendezvous(Rendezvous rendezvous) throws IllegalArgumentException, RendezvousNotFound {
        if (!(rendezvous instanceof RendezVousImpl)) {
            throw new IllegalArgumentException("L'argument fournit n'est pas le bon");
        }

        int tag = (((RendezVousImpl) rendezvous).getTag());
        if (!(RendezVousManager.containsKey(tag))) {
            throw new RendezvousNotFound("Le rendez-vous fournit n'existe pas");
        }

        RendezVousManager.remove(tag);
    }

    @Override
    public boolean removeRendezvous(Calendar calendar) {
        if (!RendezVousManager.containsKey(calendar)) {
            return false;
        }

        RendezVousManager.remove(calendar);
        return true;
    }

    @Override
    public Rendezvous updateRendezvous(Rendezvous rendezvous) throws RendezvousNotFound {
        if (!(rendezvous instanceof RendezVousImpl)) {
            throw new IllegalArgumentException("L'argument fournit n'est pas le bon");
        }

        RendezVousImpl newRendezVous = ((RendezVousImpl) rendezvous);

        if (!(RendezVousManager.containsKey(newRendezVous.getTag()))) {
            throw new RendezvousNotFound("Le rendez-vous fournit n'existe pas");
        }

        RendezVousImpl rendezVousModif = RendezVousManager.get(newRendezVous.getTag());

        newRendezVous.setTitle(rendezvous.getTitle());
        newRendezVous.setDescription(rendezvous.getDescription());
        newRendezVous.setDuration(rendezvous.getDuration());

        if (rendezVousModif.getTime() != newRendezVous.getTime()) {
            RendezVousManager.remove(newRendezVous.getTag());
            newRendezVous.setTime(rendezvous.getTime());
            RendezVousManager.put(newRendezVous.getTag(), newRendezVous);
        }

        return newRendezVous.clone();
    }

    @Override
    public void removeAllRendezvousBefore(Calendar calendar) throws IllegalArgumentException {

    }

    @Override
    public List<Rendezvous> getRendezvousBetween(Calendar calendar, Calendar calendar1) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<Rendezvous> getRendezvousBefore(Calendar calendar) throws IllegalArgumentException {
        List<RendezVousImpl> rendezvous = new ArrayList<>();
        List<Rendezvous> rendezVousClone = new ArrayList<>();

        for (RendezVousImpl rendezVousImpl: rendezvous) {
            rendezVousClone.add(rendezVousImpl.clone());
        }

        return rendezVousClone;
    }

    @Override
    public List<Rendezvous> getRendezvousAfter(Calendar calendar) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<Rendezvous> getRendezvousToday() {
        return null;
    }

    @Override
    public boolean hasOverlap(Calendar calendar, Calendar calendar1) {
        return false;
    }

    @Override
    public Calendar findFreeTime(int i, Calendar calendar, Calendar calendar1) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<Rendezvous> findRendezvousByTitleEqual(String s, Calendar calendar, Calendar calendar1) {
        return null;
    }

    @Override
    public List<Rendezvous> findRendezvousByTitleALike(String s, Calendar calendar, Calendar calendar1) {
        return null;
    }
}
