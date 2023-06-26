public class ArbolAVL <T> {
    
    Nodo head;
    

    public ArbolAVL (){
    this.head = null;
    }

    public Nodo Search(int key){

        return searchNode(head, key);     
    }

    public Nodo searchNode(Nodo n, int key){
        
        if (n==null){
            return null;
        }

        if(n.key == key){
            return n;
        }

        if(n.key > key){
            searchNode(n.left, key);
        }

        if(n.key < key){
            searchNode(n.right, key);
        }
        
        return null;
    }

    public int getMin(){
        return getMinNodo(head);
    }

    public int getMinNodo(Nodo n){
        if (n == null){
            return -1;
        }

        if (n.left == null){
            return n.key;
        }

        if(n.left!=null){
            getMinNodo(n);
        }

        return -1;
    }

    public int getMax(){
        return getMaxNodo(head);
    }

    public int getMaxNodo(Nodo n){
        if (n == null){
            return -1;
        }

        if (n.right == null){
            return n.key;
        }

        if(n.right!=null){
            getMaxNodo(n);
        }

        return -1;
    }

    public int parent(int key){
        return searchParent(head, key);
    }

    public int searchParent(Nodo n, int key){
        if (n==null){
            return -1;
        }

        if(n.key == key){
            return -1;
        }

        if (n.left.key == key && n.left != null){
            return n.key;
        }

        if (n.right.key == key && n.right != null){
            return n.key;
        }

        if(n.key > key){
            searchParent(n.left, key);
        }

        if(n.key < key){
            searchParent(n.right, key);
        }

        return -1;
        
    }

    public int[] son(int key){
        int[] sons = new int[2];

        Nodo k = Search(key);

        if (k.left == null){
            sons[1]= 0;
        } else {
            sons[1] = k.left.key;
        }

        if (k.right == null){
            sons[2]= 0;
        }else {
            sons[2] = k.right.key;
        }

        return sons;
    }

    public void insert(int key){
        this.head = insertarNodo(head ,key);
    }

    public Nodo insertarNodo(Nodo nodo, int cl){

        //si el nodo esta vacio inserta el dato alli
        if (nodo == null){
            nodo.key = cl;
        }

        if (cl < nodo.key){
            nodo.left = insertarNodo(nodo.left, cl);
        }

        if (cl > nodo.key){
            nodo.right = insertarNodo(nodo.right, cl); 
        }

        if (cl == nodo.key) {
            return nodo;
        }
        
        nodo.height = 1 + Integer.max(getHeight(nodo.left), getHeight(nodo.right));

        // se crea la bariable para ver si la nueva insercion mantiene balanceado el arbol
        int balance = getBalance(nodo);

        //rotacion a la izquierda    
        if (balance > 1 && cl < nodo.left.key) {
            return rightRotate(nodo);
        }

        //rotacion a la derecha
        if (balance < -1 && cl > nodo.right.key) {
            return leftRotate(nodo);
        }

        //doble rotacion a la izquierda
        if (balance > 1 && cl > nodo.left.key) {
            nodo.left = leftRotate(nodo.left);
            return rightRotate(nodo);
        }

       //doble rotacion a la derecha
        if (balance < -1 && cl < nodo.right.key) {
            nodo.right = rightRotate(nodo.right);
            return leftRotate(nodo);
        }

        
        return nodo;


    }

    public void remove(){

    }

    public int getHeight(Nodo n){
        if(n==null){
            return 0;
        }
        return n.height;
    }

    public int getBalance(Nodo n){
        return getHeight(n.left) - getHeight(n.right);

    }

    public Nodo rightRotate(Nodo n){
        Nodo x = n.left;
        Nodo T2 = x.right;

        x.right = n;
        n.left = T2;

        n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    public Nodo leftRotate(Nodo n){
        Nodo x = n.right;
        Nodo T2 = x.left;

        x.left = n;
        n.right = T2;

        n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

}
