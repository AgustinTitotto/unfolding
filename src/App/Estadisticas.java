package App;

import java.util.*;

public class Estadisticas {

    ArrayList<String> pilar = new ArrayList<>();
    ArrayList<String> palermo = new ArrayList<>();
    ArrayList<String> avellaneda = new ArrayList<>();
    ArrayList<String> sintomasActuales = Covid19.sintomas();

    HashMap<String, Integer> rankingPilar = new HashMap<>();
    HashMap<String, Integer> rankingAvellaneda = new HashMap<>();
    HashMap<String, Integer> rankingPalermo = new HashMap<>();

    public Estadisticas() {

    }

    public void tablaEventos() {
        distribuirZona();
        System.out.println("**********************************");
        System.out.println("_Eventos en Avellaneda:");
        printRanking(rankingAvellaneda);
        System.out.println("\n_Eventos en Pilar:");
        printRanking(rankingPilar);
        System.out.println("\n_Eventos en Palermo:");
        printRanking(rankingPalermo);
    }

    private void distribuirZona() {
        ArrayList<String> afectados = Covid19.afectados();
        for (int i = 0; i < afectados.size(); i++) {
            String[] datasplt = afectados.get(i).split("/", 3);
            if (datasplt[2].equals("Avellaneda")) {
                avellaneda.add(afectados.get(i));
            } else if (datasplt[2].equals("Pilar")) {
                pilar.add(afectados.get(i));
            } else {
                palermo.add(afectados.get(i));
            }
        }
    }

    private void eventosComunes(ArrayList<String> zona) {
        ArrayList<String> sintomasZona = new ArrayList<>();
        for (int j = 0; j < zona.size(); j++) {
            String[] datasplt = zona.get(j).split("/", 3);
            if (canIAdd(datasplt[1],sintomasZona)){
                sintomasZona.add(datasplt[1]);
            }
        }
    }

    private boolean canIAdd(String toAdd, ArrayList<String> sintomasZona) {
        for (int i = 0; i < sintomasZona.size(); i++) {
            if (sintomasZona.get(i).equals(toAdd)) {
                return false;
            }
        }
        return true;
    }

    // cuil/sintoma/zona


    private void createRanking(){
        this.rankingAvellaneda = sortByValue(getRankingPorZona(avellaneda, rankingAvellaneda));
        this.rankingPilar = sortByValue(getRankingPorZona(pilar, rankingPilar));
        this.rankingPalermo = sortByValue(getRankingPorZona(palermo, rankingPalermo));

    }

    private void printRanking(HashMap<String, Integer> zona){
        createRanking();
        int cantidad=0;
        for (String key : zona.keySet()) {
           if(cantidad<3){
               System.out.println(key);
               cantidad++;
           }
        }

    }


    private HashMap<String, Integer> getRankingPorZona(ArrayList<String> zona, HashMap<String, Integer> rankingPorZona){
        eventosComunes(zona);
        for (String sintoma: sintomasActuales) {
            int veces = 0;
            for (String datosCiudadano: zona) {
                String[] datos = datosCiudadano.split("/");
                if(sintoma.equals(datos[1])) veces++;
            }
            if(veces!=0) {
                rankingPorZona.put(sintoma, veces);
            }

        }
        return rankingPorZona;

    }
    private HashMap<String, Integer> sortByValue(HashMap<String, Integer> rankingPorZona) {
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        rankingPorZona.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return reverseSortedMap;

    }


}
