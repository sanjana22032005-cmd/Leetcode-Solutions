class LFUCache {
    class Node{
        int key;
        int value;
        int freq;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }
    class DoublyLinkedList{
        Node head;
        Node tail;
        int size;
        DoublyLinkedList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
        }
        void addToFront(Node node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;  
            head.next=node;  
            size++;
        }
        void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }
        Node removeLRU(){
            Node lru=tail.prev;
            remove(lru);
            return lru;
        }
        boolean isEmpty(){
            return size==0;
        }
    }
    HashMap<Integer,Node> keymap;
    HashMap<Integer,DoublyLinkedList> freqmap;
    int capacity;
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        keymap=new HashMap<>();
        freqmap=new HashMap<>();
        minFreq=0;
    }
    
    public int get(int key) {
        if(!keymap.containsKey(key)){
            return -1;
        }
        Node node=keymap.get(key);
        increaseFrequency(node);
        return node.value;

    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return ;
        }
        if(keymap.containsKey(key)){
            Node node=keymap.get(key);
            node.value=value;
            increaseFrequency(node);
            return;
        }
        if(keymap.size()==capacity){
            DoublyLinkedList list=freqmap.get(minFreq);
            Node node=list.removeLRU();
            keymap.remove(node.key);
        }
        Node node =new Node(key,value);
        keymap.put(key,node);
        freqmap.computeIfAbsent(1,k-> new DoublyLinkedList()).addToFront(node);
        minFreq=1;
    }
    public void increaseFrequency(Node node){
        int oldfreq=node.freq;
        DoublyLinkedList old=freqmap.get(oldfreq);
        old.remove(node);
        if(oldfreq==minFreq&&old.isEmpty()){
            minFreq++;
        }
        node.freq++;
        freqmap.computeIfAbsent(node.freq,k-> new DoublyLinkedList()).addToFront(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */