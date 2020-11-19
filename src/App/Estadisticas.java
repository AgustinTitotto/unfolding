package App;

import java.util.ArrayList;

public class Estadisticas {

    ArrayList<String> pilar = new ArrayList<>();
    ArrayList<String> palermo = new ArrayList<>();
    ArrayList<String> avellaneda = new ArrayList<>();

    public Estadisticas() {

    }

    public void tablaEventos() {
        distribuirZona();
        System.out.println("**********************************");
        System.out.println("_Eventos en Avellaneda:");
        eventosComunes(avellaneda);
        System.out.println("\n_Eventos en Pilar:");
        eventosComunes(pilar);
        System.out.println("\n_Eventos en Palermo:");
        eventosComunes(palermo);
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
        for (int i = 0; i < sintomasZona.size(); i++) {
            System.out.println(sintomasZona.get(i));
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


}
