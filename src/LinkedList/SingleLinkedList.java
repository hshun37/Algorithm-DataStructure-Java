package LinkedList;

public class SingleLinkedList<T> {
    Node<T> head = null;
    int count = 0;

    StringBuffer sb = new StringBuffer();

    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> currentNode = this.head;
            while(currentNode != null) {
                if (currentNode.data == data) {
                    return currentNode;
                } else {
                    currentNode = currentNode.next;
                }
            }
            return null;
        }
    }

    public void addNode(T data) {
        if (head == null) {
            this.head = new Node<>(data);
        } else {
            Node<T> currentNode = this.head;
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node<>(data);
        }
        this.count++;
    }

    public void insertNode(T data, T isData) {
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<>(data);
            searchedNode.next.next = nextNode;
        }
    }

    public Integer removeNode(T isData) {
        if (this.head == null) {
            return 0;
        } else {
            Node<T> currentNode = this.head;
            if (currentNode.data == isData) {
                int deleteNode = (int) this.head.data;
                this.head = this.head.next;
                return deleteNode;
            } else {
                while (currentNode.next != null) {
                    if (currentNode.next.data == isData) {
                        int deleteNode = (int) currentNode.next.data;
                        currentNode.next = currentNode.next.next;
                        return deleteNode;
                    }
                    currentNode = currentNode.next;
                }
                return 0;
            }
        }
    }

    public void printAll() {
        System.out.print("[");
        if (this.head == null) {
            System.out.println("null");
        } else {
            Node<T> currentNode = this.head;
            System.out.print(currentNode.data);
            while (currentNode.next != null) {
                currentNode = currentNode.next;
                System.out.print(", ");
                System.out.print(currentNode.data);
            }
            System.out.print("]");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        SingleLinkedList<Integer> LinkedList = new SingleLinkedList<>();


        System.out.println("========== addNode ==========");
        LinkedList.addNode(1);
        LinkedList.addNode(2);
        LinkedList.addNode(3);
        LinkedList.printAll();

        System.out.println("========== insertNode ==========");
        LinkedList.insertNode(5, 2);
        LinkedList.insertNode(5, 3);
        LinkedList.insertNode(5, 6);
        LinkedList.printAll();

        System.out.println("========== removeNode ==========");
        LinkedList.removeNode(3);
        LinkedList.removeNode(5);
        LinkedList.removeNode(5);
        LinkedList.removeNode(5);
        LinkedList.printAll();



    }
}

