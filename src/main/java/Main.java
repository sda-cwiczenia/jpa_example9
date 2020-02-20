import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("myDatabaseEmp")
                .createEntityManager();

//        EntityTransaction trn = entityManager.getTransaction();
//
//        //TypeExample typeExample = new TypeExample();
//
//        Person person = new Person("Jan", "Kowalski",35);
//        Person person1 = new Person();
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Osoba przed dodaniem do bazy : "+person);
//        System.out.println("Osoba zwracana przed dodaniem do bazy: "+person1);
//        trn.begin();
//        entityManager.persist(person);
//
//        System.out.println("Zwracany po operacji merge: "+person1);
//        person1.setNazwisko("SuperKowalski");
//
//
//        trn.commit();
//        sc.next();
//        entityManager.detach(person);
//        //person.setId(7);
//        System.out.println("Osoba po detach i setID =0");
//
//        sc.next();
//
//        trn.begin();
//        //person.setId(7);
//        person.setImie("Piotr");
//        person.setNazwisko("Nowak");
//        entityManager.merge(person);
//        trn.commit();
//
//        person.setId(1);
//
////        trn.begin();
////        person.setImie("Ada");
////        person.setNazwisko("Kwiatkowska");
////        entityManager.merge(person);
////        trn.commit();

        Osoba osoba1 = new Osoba("Jan", "Nowak", 27, "Bydgoszcz", "Wiarowa 5", "85-001");
        Osoba osoba2 = new Osoba("Marta", "Nowak", 25, "Bydgoszcz", "Kwiatowa 5", "85-001");

        entityManager.getTransaction().begin();
        entityManager.persist(osoba1);
        entityManager.persist(osoba2);
        entityManager.getTransaction().commit();

        AdresTbl adres = new AdresTbl("Bydgoszcz", "Towarowa 5", "85-002");
        OsobaTbl osoba3 = new OsobaTbl("Piotr", "Kowalski", 56, adres);

        entityManager.getTransaction().begin();
        entityManager.persist(osoba3);
        entityManager.getTransaction().commit();

        Query query = entityManager.createNativeQuery("select nazwisko, kod from osobatbl where nazwisko = 'Kowalski'");
        Iterator iterator = query.getResultList().iterator();
        while (iterator.hasNext()) {
            Object[]  result = (Object[])iterator.next();
            String nazwisko = (String) result[0];
            String kod = (String) result[1];
            System.out.println(nazwisko+" "+kod);
            String kodMiasta = kod.substring(0,2);
            System.out.println("Kod miasta "+kodMiasta);
        }


    }
}
