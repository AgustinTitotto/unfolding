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
            String[] datasplt=positivos.get(i).split("/",4);
            double ubiLongitud = Double.parseDouble(datasplt[2]);
            ubiLongitudes.add(ubiLongitud);
        }
    }

    private void getLatitudes(){
        ArrayList<String> positivos=Covid19.positivos();
        for (int i = 0; i < positivos.size(); i++) {
            String[] datasplt=positivos.get(i).split("/",4);
            double ubiLatitud = Double.parseDouble(datasplt[3]);
            ubiLatitudes.add(ubiLatitud);
        }
    }

    public ArrayList<Double> getUbiLongitudes() {
        return ubiLongitudes;
    }

    public ArrayList<Double> getUbiLatitudes() {
        return ubiLatitudes;
    }




}



