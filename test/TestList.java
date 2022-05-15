import entity.UsersEntity;
import hu.unideb.inf.HibernateConnector;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestList {

    UsersEntity user = new UsersEntity();

    @Before
    public void init(){
            user.setFullName("Lakatos Emőke");
            user.setUsername("aranyoska44");
            user.setEmail("bolyhoska@gmail.com");
            user.setPword("Almafa55");
            user.setBalance(10000);
            HibernateConnector.persistData(user);
    }

    @Test
    public void createuser(){
        try {
            user.setFullName("Trab Antal");
            user.setUsername("lada55");
            user.setEmail("ékszíj@gmail.com");
            user.setPword("Benzin666");
            user.setBalance(10000);
            HibernateConnector.persistData(user);
            System.out.println("Az sikeres felhasználó létrehozás!");
        }
        catch (Exception e){
            System.out.println("Az sikertelen felhasználó létrehozás!");
        }
    }

    @Test
    public void getname(){
        try{
            assertEquals("Lakatos Emőke", user.getFullName());
            System.out.println("Az adott felhasználó neve: " + user.getFullName());
            assertEquals("aranyoska44", user.getUsername());
            System.out.println("Az adott felhasználó userneve: " + user.getUsername());
        }
        catch(Exception e){
            System.out.println("Nincs ilyen felhasználó");
        }
    }

    @Test
    public void getpwd(){
        try{
            assertEquals("Almafa55", user.getPword());
            System.out.println("Az adott felhasználó jelszava: " + user.getPword());
        }
        catch(Exception e){
            System.out.println("Hibás jelszó!");
        }
    }

    @Test
    public void getmail(){
        try{
            assertEquals("bolyhoska@gmail.com", user.getEmail());
            System.out.println("Az adott felhasználó e-mailje: " + user.getEmail());
        }
        catch(Exception e){
            System.out.println("Hibás email!");
        }
    }

    @Test
    public void getbalance(){
        try{
            System.out.println("Az adott felhasználó balance értéke: " + user.getBalance());
        }
        catch(Exception e){
            System.out.println("Hiba!");
        }
    }

    @Test
    public void setname(){
        try{
            user.setFullName("Mekk Elek");
            assertEquals("Mekk Elek", user.getFullName());
            System.out.println("Az adott felhasználó neve: " + user.getFullName());
            user.setUsername("birka55");
            assertEquals("birka55", user.getUsername());
            System.out.println("Az adott felhasználó userneve: " + user.getUsername());
        }
        catch(Exception e){
            System.out.println("Nincs ilyen felhasználó");
        }
    }

    @Test
    public void setpwd(){
        try{
            user.setPword("kukacka888");
            assertEquals("kukacka888", user.getPword());
            System.out.println("Az adott felhasználó jelszava: " + user.getPword());
        }
        catch(Exception e){
            System.out.println("Hibás jelszó!");
        }
    }

    @Test
    public void setmail(){
        try{
            user.setEmail("galamb@gmail.com");
            assertEquals("galamb@gmail.com", user.getEmail());
            System.out.println("Az adott felhasználó e-mailje: " + user.getEmail());
        }
        catch(Exception e){
            System.out.println("Hibás email!");
        }
    }

    @Test
    public void setbalance(){
        try{
            user.setBalance(50000);
            System.out.println("Az adott felhasználó balance értéke: " + user.getBalance());
        }
        catch(Exception e){
            System.out.println("Hiba!");
        }
    }
}
