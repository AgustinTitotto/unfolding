import App.Anses;
import App.Ciudadano;
import App.Covid19;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class Testeos {

    @Test
  public void arrayCasosPositivos(){
        ArrayList<String>positivos= Covid19.positivos();
        Assert.assertNotNull(positivos);
    }

  @Test
  public void arraySintomas(){
      ArrayList<String>sintomas=Covid19.sintomas();
      Assert.assertNotNull(sintomas);
  }

  @Test
  public void listaCiudadanos(){
        ArrayList<Ciudadano>ciudadanos= Anses.listaCiudadanos();
      Assert.assertNotNull(ciudadanos);
  }

    @Test
  public void getCiu(){
        String cuil="20436406208";
        Ciudadano ciudadano=Ciudadano.getCiu(cuil);
        Assert.assertNotNull(ciudadano);
    }

    @Test
  public void bloqueo(){
        String cuil="20427059468";
        ArrayList<Ciudadano>ciudadanos=Anses.listaCiudadanos();
        Ciudadano.bloquear(cuil,ciudadanos);
        Ciudadano ciudadano=Ciudadano.getCiu("20427059468");
        assert ciudadano != null;
        Assert.assertTrue(ciudadano.block);
    }

    @Test
    public void desbloqueo(){
        String cuil="20427059468";
        ArrayList<Ciudadano>ciudadanos=Anses.listaCiudadanos();
        Ciudadano.desbloquear(cuil,ciudadanos);
        Ciudadano ciudadano=Ciudadano.getCiu("20427059468");
        assert ciudadano != null;
        Assert.assertFalse(ciudadano.block);
    }

}
