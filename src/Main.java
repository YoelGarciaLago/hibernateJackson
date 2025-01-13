import Hibernate.Metodos.MetodosAdestrador;
import Hibernate.Metodos.MetodosPokedex;
import Hibernate.Metodos.MetodosPokemon;

public class Main {
    public static void main(String[] args) {
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
//        Pokedex pokedex1 = new Pokedex("pikachu", BigDecimal.valueOf(6.0), "rata hepatítica");
//        Pokedex pokedex2 = new Pokedex("gengar", BigDecimal.valueOf(40.5), "risitas");
//        Pokedex pokedex3 = new Pokedex("Feraligatr", BigDecimal.valueOf(88.0), "mandibulon");
//        Pokedex pokedex4 = new Pokedex("tinkaton", BigDecimal.valueOf(112.8), "niña martillo");
//        Pokedex pokedex5 = new Pokedex("steelix", BigDecimal.valueOf(400.0), "durisimo");
//        Pokedex pokedex6 = new Pokedex("houndoom", BigDecimal.valueOf(35.0), "perrazo");
//        Pokedex pokedex7 = new Pokedex("sneasler", BigDecimal.valueOf(43.0), "depilador");
//        Pokedex pokedex8 = new Pokedex("aerodactyl", BigDecimal.valueOf(59.0), "terry");
//        Pokedex pokedex9 = new Pokedex("charizard", BigDecimal.valueOf(90.5), "chorizardo");
//        Pokedex pokedex10 = new Pokedex("gholdengo", BigDecimal.valueOf(30.0), "tio gilito");
//        metodosPokedex.crearPokemon_enPokedex(pokedex1);
//        metodosPokedex.crearPokemon_enPokedex(pokedex2);
//        metodosPokedex.crearPokemon_enPokedex(pokedex3);
//        metodosPokedex.crearPokemon_enPokedex(pokedex4);
//        metodosPokedex.crearPokemon_enPokedex(pokedex5);
//        metodosPokedex.crearPokemon_enPokedex(pokedex6);
//        metodosPokedex.crearPokemon_enPokedex(pokedex7);
//        metodosPokedex.crearPokemon_enPokedex(pokedex8);
//        metodosPokedex.crearPokemon_enPokedex(pokedex9);
//        metodosPokedex.crearPokemon_enPokedex(pokedex10);
//
//        Adestrador adestrador1 = new Adestrador("ad1", Date.valueOf("1900-10-2"));
//        Adestrador adestrador2 = new Adestrador("ad2", Date.valueOf("1900-10-4"));
//        metodosAdestrador.crearAdestrador(adestrador1);
//        metodosAdestrador.crearAdestrador(adestrador2);
//
//        Pokemon pokemon1 = new Pokemon("p1",Date.valueOf("1900-10-2"),pokedex1,adestrador1);
//        Pokemon pokemon2 = new Pokemon("p2",Date.valueOf("1900-10-3"),pokedex2,adestrador1);
//        Pokemon pokemon3 = new Pokemon("p3",Date.valueOf("1900-10-4"),pokedex3,adestrador1);
//        Pokemon pokemon4 = new Pokemon("p4",Date.valueOf("1900-10-5"),pokedex4,adestrador1);
//        Pokemon pokemon5 = new Pokemon("p5",Date.valueOf("1900-10-6"),pokedex5,adestrador1);
//        Pokemon pokemon6 = new Pokemon("p6",Date.valueOf("1900-10-7"),pokedex6,adestrador1);
//        Pokemon pokemon7 = new Pokemon("p7",Date.valueOf("1900-10-8"),pokedex7,adestrador2);
//        Pokemon pokemon8 = new Pokemon("p8",Date.valueOf("1900-10-9"),pokedex8,adestrador2);
//        Pokemon pokemon9 = new Pokemon("p9",Date.valueOf("1900-10-11"),pokedex9,adestrador2);
//        Pokemon pokemon10 = new Pokemon("p10",Date.valueOf("1900-10-12"),pokedex10,adestrador2);
//        Pokemon pokemon11 = new Pokemon("p11",Date.valueOf("1900-10-22"),adestrador2);
//        Pokemon pokemon12 = new Pokemon("p12",Date.valueOf("1900-10-23"),adestrador2);
//        metodosPokemon.insertarPokemon(pokemon1);
//        metodosPokemon.insertarPokemon(pokemon2);
//        metodosPokemon.insertarPokemon(pokemon3);
//        metodosPokemon.insertarPokemon(pokemon4);
//        metodosPokemon.insertarPokemon(pokemon5);
//        metodosPokemon.insertarPokemon(pokemon6);
//        metodosPokemon.insertarPokemon(pokemon7);
//        metodosPokemon.insertarPokemon(pokemon8);
//        metodosPokemon.insertarPokemon(pokemon9);
//        metodosPokemon.insertarPokemon(pokemon10);
//        metodosPokemon.insertarPokemon(pokemon11);
//        metodosPokemon.insertarPokemon(pokemon12);

//        metodosPokemon.listarPokemon();
//        metodosAdestrador.listarAdestrador();

        //metodosPokemon.escribirAJSON("/home/yoi/IdeaProjects/hibernateJackson/src/JSONs/pokemon.json",metodosPokemon.listarPokemon());
        //metodosPokemon.escribirAXML();
        //metodosAdestrador.escribirAJSON("/home/yoi/IdeaProjects/hibernateJackson/src/JSONs/adestrador.json",metodosAdestrador.listarAdestrador());
        //metodosAdestrador.escribirAXML();



        metodosPokemon.borrarTablaPk();
        metodosAdestrador.borrarTablaAdestrador();


    }
}