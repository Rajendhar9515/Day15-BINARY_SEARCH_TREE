package com.bridgelabz.hash_table;

class HashTable<K, V> {

    MyMapNode<K, V> head;
    MyMapNode<K, V> tail;

    public void add(K key, V value) {
        MyMapNode<K, V> myNode = (MyMapNode<K, V>) searchNode(key);
        if(myNode == null) {
            myNode = new MyMapNode<>(key , value);
            this.append(myNode);
        }
        else {
            myNode.setValue(value);
        }
    }

    public void append(MyMapNode<K, V> myNode) {
        if(this.head == null)
            this.head = myNode;
        if(this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    public MyMapNode<K, V> searchNode(K data) {
        MyMapNode<K, V> currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public V get(K word) {
        MyMapNode<K, V> myMapNode = searchNode(word);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void remove(K word) {
        MyMapNode<K, V> currentNode = head;
        MyMapNode<K, V> previousNode = null;
        while (currentNode != null && currentNode.getKey().equals(word)) {
            head = currentNode.getNext();
            return;
        }
        while (currentNode != null && !(currentNode.getKey().equals(word))) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode != null) {
            previousNode.next = currentNode.next;
        }
        if(currentNode == null)
            System.out.println("Word not found!");
    }

    public int size(){
        MyMapNode<K, V> currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            currentNode = currentNode.getNext();
        }
        return position;
    }

    @Override
    public String toString() {
        return "Linked List Nodes { " + head + " }";
    }

    public void printNodes() {
        if (head != null){
        System.out.println("My nodes: " + head);
        }
    }
}
