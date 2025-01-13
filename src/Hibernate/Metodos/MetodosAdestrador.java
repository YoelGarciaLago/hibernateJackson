package Hibernate.Metodos;

import Datos.Adestrador;
import Datos.Aux.Adestradores;
import Datos.Pokemon;
import Hibernate.Utilidad.Utilidad;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hibernate.query.NativeQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MetodosAdestrador {

    public void crearAdestrador(Adestrador adestrador) {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(adestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el adestrador: " + e.getMessage());
        }
    }

    public List<Adestrador> listarAdestrador() {
        List<Adestrador> adestradores = null;
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Query<Adestrador> query = session.createQuery("from Adestrador ", Adestrador.class);
            adestradores = query.list();
            adestradores.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los adestradores: " + e.getMessage());
        }
        return adestradores;
    }


    public void modificarAdestrador(int id, String nome) {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Adestrador adestrador = session.get(Adestrador.class, id);
            if (adestrador != null) {
                adestrador.setNome(nome);
                session.update(adestrador);
                transaction.commit();
            } else {
                System.out.println("No se encontro al adestrador con ese id ");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el adestrador: " + e.getMessage());
        }
    }

    public void borrarTablaAdestrador() {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            NativeQuery query = session.createSQLQuery("DELETE FROM adestrador");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al borrar la tabla de adestradores: " + e.getMessage());
        }
    }


    public void escribirAXML() {
        XmlMapper xmlMapper = new XmlMapper();
        // Configurar el XmlMapper para que use una etiqueta raíz para múltiples objetos
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter("/home/yoi/IdeaProjects/hibernateJackson/src/XMLs/adestrador.xml", true)) {
            // Obtener la lista de objetos
            List<Adestrador> list = listarAdestrador();

            // Crear una clase contenedora que sirva como raíz para los objetos
            Adestradores contenedor = new Adestradores();
            contenedor.setAdestradores(list);

            // Escribir el contenedor en el archivo
            xmlMapper.writeValue(fileWriter, contenedor);

            System.out.println("Datos añadidos al archivo XML correctamente: /home/yoi/IdeaProjects/hibernateJackson/src/XMLs/adestrador.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> void escribirAJSON(String rutaArchivo, List<T> objetos) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(rutaArchivo), objetos);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error al guardar en JSON" + e.getMessage());
        }
    }

    public List<Adestrador> lerJSON() {
        ObjectMapper objectMapper = new ObjectMapper();

        Adestradores contenedor = null;
        try {
            // Leer el archivo JSON y convertirlo en el Wrapper
            contenedor = objectMapper.readValue(
                    new File("/home/yoi/IdeaProjects/hibernateJackson/src/JSONs/adestrador.json"), Adestradores.class);

            // Acceder a los datos
            for (Adestrador adestrador : contenedor.getAdestradores()) {
                System.out.println(adestrador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenedor.getAdestradores();
    }
    public void insertarAdestrador(List<Adestrador> pokeList){
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for (Adestrador poke : pokeList) {
                session.save(poke);
            }
            transaction.commit();
            System.out.println("Pokemons guardados en la base de datos pokedex correctamente");
        }
    }
}
