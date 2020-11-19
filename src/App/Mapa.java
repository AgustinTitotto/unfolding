package App;

import java.util.ArrayList;

public class Mapa {

    private ArrayList<Double> ubiLongitudes;
    private ArrayList<Double> ubiLatitudes;

    public Mapa() {
        ubiLongitudes=new ArrayList<>();
        ubiLatitudes=new ArrayList<>();
        getLongitudes();
        getLatitudes();
    }

    private void getLongitudes(){
        ArrayList<String> positivos=Covid19.positivos();
        for (int i = 0; i < positivos.size(); i++) {
            String[] datasplt = positivos.get(i).split("/", 3);
            String zonaString = datasplt[2];
                Zona zona = getZona(zonaString);
                ubiLongitudes.add(zona.getLongitud());

        }
    }

    private void getLatitudes(){
        ArrayList<String> positivos=Covid19.positivos();
        for (int i = 0; i < positivos.size(); i++) {
            String[] datasplt = positivos.get(i).split("/", 4);
            String zonaString = datasplt[2];
                Zona zona = getZona(zonaString);
                ubiLatitudes.add(zona.getLatitud());

        }
    }

    public Zona getZona(String zona){
        switch (zona){
            case "Avellaneda": ZonaAvellaneda avellaneda=new ZonaAvellaneda();
                return avellaneda;
            case  "Palermo": ZonaPalermo   palermo=new ZonaPalermo();
                return palermo;
            case "Pilar": ZonaPilar pilar=new ZonaPilar();
                return pilar;
            default: return null;

        }
    }

    public ArrayList<Double> getUbiLongitudes() {
        return ubiLongitudes;
    }

    public ArrayList<Double> getUbiLatitudes() {
        return ubiLatitudes;
    }




}



