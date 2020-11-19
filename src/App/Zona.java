package App;

public abstract class Zona {

    final private double longitud;
    final private double latitud;

    public Zona(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }


}
