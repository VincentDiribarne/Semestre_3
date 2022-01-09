package TPNote.Version1;

import myrendezvous.Rendezvous;
import myrendezvous.RendezvousManager;
import myrendezvous.exceptions.RendezvousNotFound;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class RDVTest {

    static Rendezvous rdv1 = null;
    static Rendezvous rdv2 = null;
    static Rendezvous rdv3 = null;
    static RendezvousManager manager = new RendezVousManagerImpl();

    @BeforeClass
    public static void setUp() {
        Calendar timeRDV1 = Calendar.getInstance();
        Calendar timeRDV2 = Calendar.getInstance();
        timeRDV2.add(Calendar.MINUTE, 12);
        Calendar timeRDV3 = Calendar.getInstance();
        timeRDV3.add(Calendar.MINUTE, 17);
        rdv1 = new RendezVousImpl("Allez chez le medecin", "Medecin", 60, timeRDV1);
        rdv2 = new RendezVousImpl("Allez chez le coiffeur", "Coiffeur", 60, timeRDV2);
        rdv3 = new RendezVousImpl("Allez à la pharmacie", "Pharmacie", 60, timeRDV3);
    }

    @Test
    public void testAdd() {
        assertEquals("Ajout RDV", rdv1.getTime(), manager.addRendezvous(rdv1).getTime());
        assertEquals("Ajout RDV", rdv2.getTime(), manager.addRendezvous(rdv2).getTime());
        assertEquals("Ajout RDV", rdv3.getTime(), manager.addRendezvous(rdv3).getTime());
    }

    @Test
    public void testFoundTitleEqual() {
        assertEquals(rdv1.getTime(), manager.findRendezvousByTitleEqual("Medecin", rdv1.getTime(), Calendar.getInstance()).get(0).getTime());
        assertEquals(rdv1.getTime(), manager.findRendezvousByTitleEqual("Medecin", rdv1.getTime(), null).get(0).getTime());
        assertEquals(rdv1.getTime(), manager.findRendezvousByTitleEqual("Medecin", null, Calendar.getInstance()).get(0).getTime());
        assertEquals(rdv2.getTime(), manager.findRendezvousByTitleEqual("Coiffeur", null, null).get(0).getTime());
    }

    @Test
    public void testFoundTitleALike() {
        assertEquals(rdv1.getTime(), manager.findRendezvousByTitleALike("MeDeCiN", rdv1.getTime(), Calendar.getInstance()).get(0).getTime());
        assertEquals(rdv1.getTime(), manager.findRendezvousByTitleALike("medecine", rdv1.getTime(), null).get(0).getTime());
        assertEquals(rdv1.getTime(), manager.findRendezvousByTitleALike("medecin", null, Calendar.getInstance()).get(0).getTime());
        assertEquals(rdv2.getTime(), manager.findRendezvousByTitleALike("CoIfFeUr", null, null).get(0).getTime());
    }

    @Test
    public void testUpdate() throws RendezvousNotFound {
        assertEquals("Le rendezvous doit être modifié", rdv3.getTime(), manager.updateRendezvous(rdv3).getTime());
    }

    @Test
    public void testDelete() {
        assertTrue("Le rendezvous doit être supprimé", manager.removeRendezvous(rdv1.getTime()));
    }
}
