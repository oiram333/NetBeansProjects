public class Nodo{
    
    public Integer numProceso;
    public String nomProceso;
    public Integer tamaño;
    public Integer tiempo;
    
    public Nodo(Integer numProceso, String nomProceso, Integer tamaño, Integer tiempo){
        this.numProceso = numProceso;
        this.nomProceso = nomProceso;
        this.tamaño = tamaño;
        this.tiempo = tiempo;
    }

    public Integer getNumProceso() {
        return numProceso;
    }

    public String getNomProceso() {
        return nomProceso;
    }

    public Integer getTamaño() {
        return tamaño;
    }

    public Integer getTiempo() {
        return tiempo;
    }
    /*
    public void setNumProceso(Integer numProceso) {
        this.numProceso = numProceso;
    }

    public void setNomProceso(String nomProceso) {
        this.nomProceso = nomProceso;
    }

    public void setTamaño(Integer tamaño) {
        this.tamaño = tamaño;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }
    */
    @Override
    public String toString(){
        return "["+"Numero de Proceso: "+numProceso+" Nombre del proceso: "+nomProceso+" Tamaño del proceso: "+tamaño+" Tiempo del proceso: "+tiempo+"]------>";
    }
}
