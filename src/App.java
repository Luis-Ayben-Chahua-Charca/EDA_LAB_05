public class App {
    public static void main(String[] args) throws Exception {
        ArbolAVL AVL = new ArbolAVL<Integer>();

        AVL.insert(5);
        AVL.insert(6);
        AVL.insert(8);
        AVL.insert(7);
        AVL.insert(10);

        int max = AVL.getMax();
        System.out.println("maximo = " + max);
        
        int min = AVL.getMin();
        System.out.println("maximo = " + min);

        Nodo n = AVL.Search(2);

        int padre = AVL.parent(10);
        System.out.println("el padre de: 10 es: " + padre);

        int[] hijos = AVL.son(8);
        System.out.println("los hijos de 8 son " + hijos[0] + hijos[1]);

        Grafico graf = new Grafico(AVL);
        graf.Graphic();
    }
}
