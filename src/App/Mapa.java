package App;

import java.util.ArrayList;

public class Mapa {

    private ArrayList<Double> ubiLongitudes;
    private ArrayList<Double> ubiLatitudes;
    ArrayList<String> ubicaciones;

    public Mapa() {
        ubiLongitudes=new ArrayList<>();
        ubiLatitudes=new ArrayList<>();
        getLongitudes();
        getLatitudes();
        ubicaciones=new ArrayList<>();
        getLocations();
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

    private void getLocations(){
        ArrayList<String> positivos=Covid19.positivos();
        for (int i = 0; i < positivos.size(); i++) {
            String[] datasplt=positivos.get(i).split("/",3);
            ubicaciones.add(datasplt[2]);
        }
    }

    public ArrayList<Double> getUbiLongitudes() {
        return ubiLongitudes;
    }

    public ArrayList<Double> getUbiLatitudes() {
        return ubiLatitudes;
    }

    public int length(){
        return ubicaciones.size();
    }

    public int length2(){
        return ubiLongitudes.size();
    }

    public int length3(){
        return ubiLatitudes.size();
    }




    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        System.out.println(mapa.length2());
        System.out.println(mapa.length3());

    }


}



