package tasks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tasks.crudServices.ClientCrudService;
import tasks.crudServices.TicketCrudService;
import tasks.entities.Client;
import tasks.entities.Planet;
import tasks.crudServices.PlanetCrudService;
import tasks.entities.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();


        Session session = sessionFactory.openSession();


        PlanetCrudService planetCrudService = new PlanetCrudService(sessionFactory.createEntityManager());


        // Ticket CRUD service-------------------------------------------


        ClientCrudService ccs = new ClientCrudService(sessionFactory.createEntityManager());
        Client client = ccs.findById(2L);

        System.out.println("OKAY OKAY OKAY");

        Planet startPlanet = planetCrudService.findById("SAT");
        Planet endPlanet = planetCrudService.findById("TAT");

        System.out.println("OKAY OKAY OKAY");





        System.out.println("OKAY OKAY OKAY");
        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setFromPlanet(startPlanet);
        ticket.setToPlanet(endPlanet);
        ticket.setCreatedAt(LocalDateTime.of(2024, 4, 12, 15, 30));


        TicketCrudService ticketCrudService = new TicketCrudService(sessionFactory.createEntityManager());
        System.out.println("OKAY OKAY OKAY");
        ticketCrudService.save(ticket);

        System.out.println("OKAY OKAY OKAY");


        System.out.println("OKAY OKAY OKAY");
        List<Ticket> tickets = ticketCrudService.findAll();

        System.out.println(tickets);
        System.out.println("OKAY OKAY OKAY");


        session.close();
        sessionFactory.close();



    }
}