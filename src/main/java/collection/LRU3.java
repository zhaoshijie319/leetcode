package collection;

import java.util.Hashtable;

public class LRU3<K, V> {
    class Entry<K, V> {
        Entry pre;
        Entry next;
        K key;
        V value;
    }

    private int cacheSize;
    private Hashtable<K, Entry<K, V>> hashtable;
    private int current;
    private Entry first;
    private Entry last;

    public LRU3(int cacheSize) {
        current = 0;
        this.cacheSize = cacheSize;
        hashtable = new Hashtable<>(cacheSize);
    }

    public Entry get(K key) {
        Entry node = hashtable.get(key);
        if (null == node) {
            return null;
        } else {
            moveToHead(node);
            return node;
        }
    }

    public void put(K key, V value) {
        Entry node = hashtable.get(key);
        if (null == node) {
            if (current >= cacheSize) {
                remove((K) last.key);
                removeLast();
            } else {
                current++;
            }
            node = new Entry();
        }
        node.key = key;
        node.value = value;
        moveToHead(node);
        hashtable.put(key, node);
    }

    public void remove(K key) {
        Entry node = hashtable.get(key);
        if (null != node) {
            if (null != node.pre) {
                node.pre.next = node.next;
            }
            if (null != node.next) {
                node.next.pre = node.pre;
            }
        }
        if (last == node) {
            last = node.pre;
        }
        if (first == node) {
            first = node.next;
        }
        hashtable.remove(key);
    }

    private void removeLast() {
        if (null != last) {
            if (null != last.pre) {
                last.pre.next = null;
            } else {
                first = null;
                last = last.pre;
            }
        }
    }

    private void moveToHead(Entry node) {
        if (first == node) {
            return;
        }
        if (null != node.pre) {
            node.pre.next = node.next;
        }
        if (null != node.next) {
            node.next.pre = node.pre;
        }
        if (last == node) {
            last = last.pre;
        }
        if (null != first) {
            node.next = first;
            first.pre = node;
        }
        first = node;
        first.pre = null;
        if (null == last) {
            last = first.next;
        }
    }

    public void clear() {
        first = null;
        last = null;
        current = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Entry entry = first;
        while (null != entry) {
            stringBuilder.append(String.format("%s:%s ", entry.key, entry.value));
            entry = entry.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRU3<Integer, Integer> lru1 = new LRU3<>(5);
        lru1.put(1, 1);
        lru1.put(2, 2);
        lru1.put(3, 3);
        System.out.println(lru1);
        lru1.put(4, 4);
        lru1.put(5, 5);
        lru1.get(2);
        System.out.println(lru1);
    }
}
