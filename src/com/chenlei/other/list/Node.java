package com.chenlei.other.list;

/**
 * @author chenlei
 * @since 2017 - 06 - 17 11:36
 */
class Node {
    Node(int value, Node pNext) {
        this.value = value;
        this.pNext = pNext;
    }
    int value;
    Node pNext;
}
