package Hibernate.Metodos;

import Datos.Pokemon;
import Hibernate.Utilidad.Utilidad;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public void escribirAXML(){
        XmlMapper xmlMapper = new XmlMapper();
        try (FileWriter fileWriter = new FileWriter("/home/yoi/IdeaProyects/ACCESO_A_DATOS/src/XMLs/pokemon.xml", true)) {
            List<Pokemon> list = listarPokemon();
            for(Pokemon p : list){
                xmlMapper.writeValue(fileWriter,p);
            }
            System.out.println("Datos añadidos al archivo XML correctamente: /home/yoi/IdeaProyects/ACCESO_A_DATOS/src/XMLs/pokemon.xml");
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
}
