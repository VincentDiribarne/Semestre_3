package TPNote.Version1;

import myrendezvous.Rendezvous;
import myrendezvous.RendezvousManager;
import myrendezvous.exceptions.RendezvousNotFound;
import myrendezvous.utils.StringComparator;

import java.util.*;
import java.util.stream.Collectors;

public class RendezVousManagerImpl implements RendezvousManager {
    TreeMap<Calendar, RendezVousImpl> RendezVousManager = new TreeMap<>();

    @Override
    public Rendezvous addRendezvous(Rendezvous rdv) {
        RendezVousImpl rendezVous = new RendezVousImpl(rdv.getTitle(), rdv.getDescription(), rdv.getDuration(), rdv.getTime());
        if (RendezVousManager.containsKey(rendezVous.getTag())) {
            try {
                throw new RendezvousNotFound("Le rendez vous existe déjà");
            } catch (RendezvousNotFound e) {
                e.printStackTrace();
            }
        }
        RendezVousManager.put(rendezVous.getTag(), rendezVous);
        System.out.println(rendezVous.getTitle());
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
        Calendar tag = newRendezVous.getTag();

        if (!(RendezVousManager.containsKey(tag))) {
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
    public List<Rendezvous> findRendezvousByTitleEqual(String string, Calendar calendar, Calendar calendar1) {

        if (calendar == null && calendar1 == null) {
            List<Rendezvous> rendezVousTitle = new ArrayList<>();
            for (Rendezvous rendezvous : RendezVousManager.values()) {
                if (StringComparator.isAlike(string, rendezvous.getDescription())) {
                    rendezVousTitle.add(rendezvous);
                }
            }
            return rendezVousTitle;
        }

        if (calendar == null) {
            return isEquals(getRendezvousBefore(calendar1), string);
        }

        if (calendar1 == null) {
            return isEquals(getRendezvousAfter(calendar), string);
        }

        List<Rendezvous> RDV_Between = getRendezvousBetween(calendar, calendar1);
        return isEquals(RDV_Between, string);
    }

    public List<Rendezvous> isEquals(List<Rendezvous> list, String string) {
        List<Rendezvous> rendezVousTitle = new ArrayList<>();
        for (Rendezvous rendezvous : list) {
            if (StringComparator.isEqualNoCase(rendezvous.getDescription(), string)) {
                rendezVousTitle.add(rendezvous);
            }
        }
        return rendezVousTitle;
    }

    @Override
    public List<Rendezvous> findRendezvousByTitleALike(String title, Calendar calendar, Calendar calendar1) {

        if (calendar == null && calendar1 == null) {
            List<Rendezvous> rendezVousTitle = new ArrayList<>();
            for (Rendezvous rendezvous : RendezVousManager.values()) {
                if (StringComparator.isAlike(title, rendezvous.getDescription())) {
                    rendezVousTitle.add(rendezvous);
                }
            }
            return rendezVousTitle;
        }

        if (calendar == null) {
            return isAlike(getRendezvousBefore(calendar1), title);
        }

        if (calendar1 == null) {
            return isAlike(getRendezvousAfter(calendar), title);
        }

        List<Rendezvous> RDV_Between = getRendezvousBetween(calendar, calendar1);
        return isAlike(RDV_Between, title);
    }

    public List<Rendezvous> isAlike(List<Rendezvous> list, String title) {
        List<Rendezvous> rendezVousTitle = new ArrayList<>();
        for (Rendezvous rendezvous : list) {
            if (StringComparator.isAlike(title, rendezvous.getDescription())) {
                rendezVousTitle.add(rendezvous);
            }
        }

        return rendezVousTitle;
    }

    @Override
    public boolean hasOverlap(Calendar calendar, Calendar calendar1) {
        List<Rendezvous> rendezvous = getRendezvousBetween(calendar, calendar1);

        for (Rendezvous rendezvous1 : rendezvous) {
            Calendar tempsDebut = rendezvous1.getTime();
            Calendar tempsFin = rendezvous1.getTime();
            tempsFin.add(Calendar.MINUTE, rendezvous1.getDuration());
            for (Rendezvous rendezvous2 : rendezvous) {
                if (rendezvous2.getTime().before(tempsFin) || rendezvous2.getTime().after(tempsDebut)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Calendar findFreeTime(int duration, Calendar calendar, Calendar calendar1) throws IllegalArgumentException {
        List<Rendezvous> rendezvous = getRendezvousBetween(calendar, calendar1);

        for (Rendezvous rendezvous1 : rendezvous) {
            Calendar tempsDebut = rendezvous1.getTime();
            Calendar tempsNecessaire = rendezvous1.getTime();
            tempsNecessaire.add(Calendar.MINUTE, -rendezvous1.getDuration());
            if (!hasOverlap(tempsNecessaire, tempsDebut)) {
                return tempsNecessaire;
            }
        }

        throw new IllegalArgumentException("Aucun rendez vous n'a pu etre trouvé avec la durée fourni");
    }
}
