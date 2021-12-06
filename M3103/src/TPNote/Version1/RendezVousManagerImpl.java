package TPNote.Version1;

import TPNote.Version1.Exception.RendezVousExistant;
import myrendezvous.Rendezvous;
import myrendezvous.RendezvousManager;
import myrendezvous.exceptions.RendezvousNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class RendezVousManagerImpl implements RendezvousManager {
    TreeMap<Calendar, RendezVousImpl> RendezVousManager = new TreeMap<>();

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

        Calendar tag = (((RendezVousImpl) rendezvous).getTag());
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
        RendezVousManager.headMap(calendar).clear();
    }

    @Override
    public List<Rendezvous> getRendezvousBetween(Calendar calendar, Calendar calendar1) throws IllegalArgumentException {
        return RendezVousManager.subMap(calendar, calendar1).values().stream().map(RendezVousImpl::clone).collect(Collectors.toList());
    }

    @Override
    public List<Rendezvous> getRendezvousBefore(Calendar calendar) throws IllegalArgumentException {
        return RendezVousManager.headMap(calendar).values().stream().map(RendezVousImpl::clone).collect(Collectors.toList());
    }

    @Override
    public List<Rendezvous> getRendezvousAfter(Calendar calendar) throws IllegalArgumentException {
        return RendezVousManager.tailMap(calendar).values().stream().map(RendezVousImpl::clone).collect(Collectors.toList());
    }

    @Override
    public List<Rendezvous> getRendezvousToday() {
        Calendar today = Calendar.getInstance();
        Calendar tomorrow = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        tomorrow.set(Calendar.HOUR_OF_DAY, 0);
        tomorrow.add(Calendar.DAY_OF_WEEK, 1);

        return getRendezvousBetween(today, tomorrow);
    }

    @Override
    public boolean hasOverlap(Calendar calendar, Calendar calendar1) {
        List<Rendezvous> rendezvous = getRendezvousBetween(calendar, calendar1);
        return rendezvous.size() != 0;
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
