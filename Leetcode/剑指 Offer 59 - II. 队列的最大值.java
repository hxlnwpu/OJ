class MaxQueue {
    Deque<Integer> queue = new LinkedList<>();
    public MaxQueue() {

    }

    public int max_value() {
        if(queue.isEmpty()) return -1;
       return Collections.max(queue);
    }

    public void push_back(int value) {
       queue.add(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        return queue.pollFirst();
    }
}

/**
 * 方法2
 */
class MaxQueue {
    Deque<Integer> res, max;
    public MaxQueue() {
        res = new LinkedList<Integer>();
        max = new LinkedList<Integer>();
    }
    
    public int max_value() {
        if(max.isEmpty()) return -1;
        return max.peekFirst();
    }
    
    public void push_back(int value) {
        res.addLast(value);
        while(!max.isEmpty() && max.peekLast()<value) max.removeLast();
        max.addLast(value);
    }
    
    public int pop_front() {
        if(res.isEmpty()) return -1;
        int temp = res.peekFirst();
        if(temp == max.peekFirst()) max.removeFirst();
        res.removeFirst();
        return temp;
    }
}