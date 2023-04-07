package TreeDZ;

class Tree{
    Node root;
    public Tree() {
        this.root = null;
    }
    public void add(int value){
        root = addRec(root, value);
    }
    private Node addRec(Node root, int n){
        if(root == null){
            Node NewNode = new Node(n);
            return NewNode;
        }
        if(root.value > n){
            root.left = addRec(root.left , n);
        }
        if(root.value < n){
            root.right = addRec(root.right, n);
        }
        return root;
    }
    public boolean findRec(int value){
        return contains(root, value);
    }
    public boolean contains(Node e, int n) {
        if (e == null) {
            return false;
        }
        if (root.value == n) {
            return true;
        } else if (n > e.value) {
            return contains(e.left, n);
        } else {
            return contains(e.right, n);
        }
    }
    public void traverse(Node root){
        if(root != null){
            traverse(root.left);
            System.out.println(root.value);
            traverse(root.right);
        }
    }
}
