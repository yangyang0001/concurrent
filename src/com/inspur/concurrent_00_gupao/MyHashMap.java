package com.inspur.concurrent_00_gupao;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-23 15:19
 */
public class MyHashMap {
    private static Node<String, String> [] nodes = new Node[8];
    private static int size = 0;

    public Object put(Object key, Object value) {
        Node<String, String> p;
        int hash = Math.abs(key.hashCode() % 8);
        System.out.println(key + "的hash is :" + hash);
        p = nodes[hash];
        if(p == null) {
            nodes[hash] = new Node(key, value, null);
            size ++;
            return value;
        } else {
            //获取最头部的 Node 的值!
            Object oldValue = nodes[hash].getValue();
            nodes[hash] = new Node(key, value, nodes[hash]);
            size ++;
            return oldValue;
        }
    }

    public Object get(Object key) {
        Node<String, String> p;
        int hash = Math.abs(key.hashCode() % 8);
        System.out.println(key + "的hash is :" + hash);
        p = nodes[hash];
        if(p == null) {
            return null;
        } else {
            //获取最头部的 Node 的值!
            Object value = nodes[hash].getValue();
            return value;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        for (int i = 0; i < 20; i++) {
            myHashMap.put("Yang" + i, "Yang" + i);
        }
        System.out.println(myHashMap);
    }

    class Node<K, V> {
        private K key;
        private V value;
        private Node next;

        public Node() {}

        public Node(K key, V vlaue) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
