/**
 * Created by jr69473 on 5/29/17.
 */

class Node<T>(val data: T){
    var next: Node<T>? = null
}

fun <T> removeDupsFromUnsortedList(node: Node<T>): Node<T> {
    val set = mutableSetOf<T>()
    var prev = node
    var current = node.next

    while (current != null){
        if (set.contains(current.data)){
            prev.next = current.next
        }
        else {
            set.add(current.data)
            prev = current
        }

        current = current.next
    }

    return node
}

fun main(args: Array<String>){
    var head = Node(5).apply {
        next = Node(4).apply {
            next = Node(3).apply {
                next = Node(3).apply {
                    next = Node(4)
                }
            }
        }
    }

    var result = removeDupsFromUnsortedList(head)
}