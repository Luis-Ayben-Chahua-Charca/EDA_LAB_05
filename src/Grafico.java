import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Grafico {
    private ArbolAVL arbol;
    private static Graph graph;

    public Grafico(ArbolAVL arbol) {
        this.arbol = arbol;
       
    }

    public void Graphic(){
        System.setProperty("org.graphstream.ui", "swing");
		
		graph = new SingleGraph("AVL");

        agregarNodos();
        graph.display();
    }

    public void agregarNodos(){
        addNodo(arbol.head, -1);
    }
    public void addNodo(Nodo n, int key){

        Node aux;
        if(n!=null){
            aux = graph.addNode("" + n.key);
            aux.setAttribute("ui.label", "Nodo : " + n.key);

            setEdge(key, n.key);
            if(n.right!=null){
                addNodo(n.right,n.key);
            }
            if(n.left!=null){
                addNodo(n.left,n.key);
            }
        }

    }

    public void setEdge(int parent, int son){
        if (parent != -1){
            graph.addEdge(parent + son + "", ""+parent , ""+son);
        }
    }
}