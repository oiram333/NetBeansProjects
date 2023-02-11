/** 
 * @author Mario Moreno
 */

public class Pila {
    private int contNodo = 0;
    private Nodo head;

    public int getContNodo() {
        return contNodo;
    }

    public Nodo getHead() {
        return head;
    }
    public void push(Nodo N){
        contNodo++;
        if(head==null){
            head = N;
        }else{
            N.setDown(head);
            head.setUp(N);
            head = N;
        }
    }
    
    public void pop(){
        if(contNodo>0){
            contNodo--;
            head = head.getDown();
        }
    }
    
    public String peek(){
        return head.getDato();
    }
}
