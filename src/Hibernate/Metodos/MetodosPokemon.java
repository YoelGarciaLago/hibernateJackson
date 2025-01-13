package Hibernate.Metodos;

import Datos.Adestrador;
import Datos.Aux.Adestradores;
import Datos.Aux.Pokemons;
import Datos.Pokedex;
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

public class MetodosPokemon {

    /**
     * Inserta 12 pokemon en la tabla Pokemon(6 para cada adestrador)
     */
    public void insertarPokemon(Pokemon pokemon) {
        try(Session session = Utilidad.getSessionFactory().openSession()){
         Transaction transaction = session.beginTransaction();
         session.save(pokemon);
         transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar los pokemons: " + e.getMessage());
        }
    }

    public List<Pokemon> listarPokemon(){
        List<Pokemon> pokemon = null;
        try(Session session = Utilidad.getSessionFactory().openSession()){
            Query<Pokemon> query = session.createQuery("from Pokemon", Pokemon.class);
            pokemon = query.list();
            pokemon.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los pokemons: " + e.getMessage());
        }
        return pokemon;
    }

    public void escribirAXML() {
        XmlMapper xmlMapper = new XmlMapper();
        // Configurar el XmlMapper para que use una etiqueta raíz para múltiples objetos
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter("/home/yoi/IdeaProjects/hibernateJackson/src/XMLs/pokemon.xml", true)) {
            // Obtener la lista de objetos
            List<Pokemon> list = listarPokemon();

            // Crear una clase contenedora que sirva como raíz para los objetos
            Pokemons contenedor = new Pokemons();
            contenedor.setPokemons(list);

            // Escribir el contenedor en el archivo
            xmlMapper.writeValue(fileWriter, contenedor);

            System.out.println("Datos añadidos al archivo XML correctamente: /home/yoi/IdeaProjects/hibernateJackson/src/XMLs/adestrador.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public <T> void escribirAJSON(String rutaArchivo, List<T> objetos){
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File(rutaArchivo),objetos);
            System.out.println();
        }catch (IOException e){
            System.out.println("Error al guardar en JSON"+ e.getMessage());
        }
    }
    public void borrarTablaPk(){
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            NativeQuery query = session.createSQLQuery("DELETE FROM pokemon");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al borrar la tabla de pokemon: " + e.getMessage());
        }
    }

    public List<Pokemon> lerJSON() {
        ObjectMapper objectMapper = new ObjectMapper();

        Pokemons contenedor = null;
        try {
            // Leer el archivo JSON y convertirlo en el Wrapper
            contenedor = objectMapper.readValue(
                    new File("/home/yoi/IdeaProjects/hibernateJackson/src/JSONs/pokemon.json"), Pokemons.class);

            // Acceder a los datos
            for (Pokemon adestrador : contenedor.getPokemons()) {
                System.out.println(adestrador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenedor.getPokemons();
    }
    public void insertarPokemonsInPokedex(List<Pokemon> pokeList){
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for (Pokemon poke : pokeList) {
                session.save(poke);
            }
            transaction.commit();
            System.out.println("Pokemons guardados en la base de datos pokedex correctamente");
        }
    }
}
