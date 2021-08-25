package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fxzou
 * @date 2021/8/24
 * @since IntelliJ IDEA
 */
public class Lc146LRUCache {

    public Map<Integer, Node> map;

    public DoubleList cache;

    public int cap;


    public Lc146LRUCache(int capacity) {
        cache = new DoubleList();

        map = new HashMap<>();

        this.cap = capacity;

    }

    public int get(int key) {
        // 如果key存在，则输出key ，否则输出 -1
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            int val = node.val;
            cache.moveToHead(node);
            return val;
        }

    }

    public void put(int key, int value) {
        // 先构建Node节点
        Node node = new Node(key, value);

        // 若存在key，则删除旧的数据，将新的放到头部
        if (map.containsKey(key)) {
            cache.moveToHead(node);
            // 更新map中对应的数据
            map.put(key, node);
        } else {
            // 如果cache已满
            if (cap >= cache.size) {
                // 删除尾节点
                // 删除map中映射到该数据的键
                Node lastNode = cache.removeLast();
                map.remove(lastNode.key);
            }
            // 将新节点插入到开头 addFirst
            cache.addFirst(node);
            // map 中新建key对节点x的映射
            map.put(key, node);
        }
    }


    /**
     * 构建节点
     */
    public class Node {
        public int key;
        public int val;

        public Node next, pre;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    /**
     * 构建双向链表
     */
    public class DoubleList {
        /**
         * 头节点
         */
        public Node head;
        /**
         * 尾节点
         */
        public Node tail;

        public int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            // 头节点指向尾部
            head.pre = tail;
            // 尾节点指向头部
            tail.next = head;
            size = 0;
        }

        /**
         * 头插
         *
         * @param node
         */
        public void addFirst(Node node) {
//            Node headNext = head.next;
//            head.next = x;
//            headNext.pre = x;
//            x.pre = head;
//            x.next = headNext;
            // head <-> [pre]node <-> head.next 插入值1.pre 指向head
            node.pre = head;

            // node.next 指向head.next
            node.next = head.next;

            // head.next.pre 指向node
            head.next.pre = node;

            // head.next 改为node
            head.next = node;

            size++;

        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public Node removeLast() {
            Node tempTail = tail;

            remove(tempTail);

            return tempTail;
        }

        public void moveToHead(Node node){
            removeLast();
            addFirst(node);
        }


        public int size() {
            return size;
        }

    }
}
