import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Arbol {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
		
		Graph graph = new SingleGraph("Tutorial 1");

		Node node1 = graph.addNode("A");
        Node node2 = graph.addNode("B");
        Node node3 = graph.addNode("C");
        
        node1.setAttribute("ui.label", "Nodo A");
        node2.setAttribute("ui.label", "Nodo B");
        node3.setAttribute("ui.label", "Nodo C");
        

		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");

		graph.display();
    }
}
