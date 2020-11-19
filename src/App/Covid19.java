package App;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Covid19 extends LectorArchivos {

    String cuil;
    int sintoma;

    public Covid19(String cuil, int sintoma){
        this.cuil=cuil;
        this.sintoma=sintoma;
    }

    public static ArrayList<String> positivos(){
        return  createList("src\\App\\PositiveCovid");
    }

    public static ArrayList<String> afectados(){
        return createList("src\\App\\Afectados");
    }

    public static ArrayList<String> sintomas(){
        return createList("src\\App\\Sintomas");
    }

    public void afectado(){
        Ciudadano ciudadano=Ciudadano.getCiu(cuil);
        ArrayList<String>sintomas=sintomas();
        String toAdd=this.cuil + "/" + sintomas.get(this.sintoma-1) +"/"+ciudadano.zona+ "\n";
        añadir("src\\App\\Afectados",toAdd);
        checkCovid();
    }

    public void desafectado(){
        ArrayList<String> afectados=createList("src\\App\\Afectados");
        ArrayList<String> sintomas=sintomas();
        String eleccion=sintomas.get(this.sintoma-1);

        for (int i = 0; i < afectados.size(); i++) {
            String[] datasplt = afectados.get(i).split("/", 3);
            if (datasplt[0].equals(this.cuil) && datasplt[1].equals(eleccion))
                afectados.set(i,null);
        }

        escribirLista("src\\App\\Afectados",afectados);
    }

    private void checkCovid() {
        Ciudadano ciudadano=Ciudadano.getCiu(cuil);
        ArrayList<String> afectados =createList("src\\App\\Afectados");
        int x = 0;
        for (int i = 0; i < afectados.size(); i++) {
            String[] dataspltAfectados = afectados.get(i).split("/", 3);
            if (dataspltAfectados[0].equals(this.cuil) && canIadd(cuil)){
                    x++;
                }

            }
        if(x>1){

            String toAdd=cuil+"/"+ LocalDate.now()+"/"+ciudadano.zona+"\n";
            añadir("src\\App\\PositiveCovid",toAdd);
            System.out.println("Es muy probable que usted padezca Covid-19, tome las precauciones necesarias.\n" +
                    "Encontraras mas informacion en el siguiente link:\n" +
                    "https://www.who.int/es/emergencies/diseases/novel-coronavirus-2019/advice-for-public/q-a-coronaviruses#:~:text=sintomas");
        }
    }

    private boolean canIadd(String cuil){
        ArrayList<String>positivos=positivos();
        for (int i = 0; i < positivos.size(); i++) {
            String[] datasplt=positivos.get(i).split("/",3);
            if (datasplt[0].equals(cuil)){
                return false;
            }
        }
        return true;
    }


    public static void saveSintom(ArrayList<String> sintomas){
        escribirLista("src\\App\\Sintomas",sintomas);
    }

}
